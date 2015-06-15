package javaTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JMeterTest extends AbstractJavaSamplerClient {

    private final static String TEST_LABEL = "TcpDB";

    private final static short EXPECTED_HEAD = 0x8900 & 0xff;

    private final static byte EXPECTED_HEART = 0x00;

    BufferedOutputStream bos;
    BufferedInputStream bis;

    public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		// params.addArgument("ip", "192.168.0.18");
		// params.addArgument("port", "8088");

		params.addArgument("ip", "127.0.0.1");
		params.addArgument("port", "18567");

		return params;
	}
    
    public SampleResult runTest(JavaSamplerContext arg0) {

	String ip = arg0.getParameter("ip");
	int port = arg0.getIntParameter("port");
	SampleResult sr = new SampleResult();
	sr.setSampleLabel(TEST_LABEL);
	Socket socket = null;
	try {

	    socket = new Socket(ip, port);
	    socket.setSoTimeout(2000);
	    bos = new BufferedOutputStream(socket.getOutputStream());
	    bis = new BufferedInputStream(socket.getInputStream());

	    byte[] data = { 9, 0, 1, 1, 4, 0, 29, 1, 1, 13, 8, 13, 9, 18, 24,
		    3, 0, 2, 0, -71, 103, 43, 0, 3, 0, 59, 69, -57, 0, 11, 0,
		    4, 56, 120, -48, 39 };
	    byte[] auth = { 9, 0, 1, 1, 1, 0, 30, 1, 65, 65, 49, 50, 51, 52,
		    53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 49, 49, 49, 49,
		    49, 49, 49, 49, -69, -100, -123, 117 };

	    ByteBuffer buf = ByteBuffer.allocate(auth.length);
	    ByteBuffer buf1 = ByteBuffer.allocate(data.length);
	    buf.put(auth);
	    buf1.put(data);
	    buf1.flip();
	    buf.flip();
	    int i = 0;

	    // byte[] reHead = new byte[2];
	    while (true) {

		try {
		    if (i == 0) {
			bos.write(buf.array());

			bos.flush();
		    }
		    int length = bis.available();
		    if (length != 0) {

			byte[] dataT = new byte[length];
			if (length > 3) {
			    byte serial = dataT[3];
			}
			if (length == 4) {

			} else {
			    bis.read(dataT);
			    short head = (short) (((dataT[1] & 0xFF) << 8) | (dataT[0] & 0xff));
			    if (head != EXPECTED_HEAD) {
				break;
			    }
			}
		    }
		} catch (IOException e) {
		    sr.setSuccessful(false);
		}

		if (i == 2) {
		    try {
			bos.write(buf1.array());
			bos.flush();
	
			sr.setSuccessful(true);
			break;
		    } catch (IOException e) {
			sr.setSuccessful(false);
		    }

		    break;
		}
		i++;

	    }
	} catch (UnknownHostException e1) {

	    sr.setSuccessful(false);
	} catch (IOException e1) {

	    sr.setSuccessful(false);
	} finally {
	    try {

		bos.close();
		bis.close();
		socket.close();
	    } catch (IOException e) {

		sr.setSuccessful(false);
	    }
	}

	return sr;
    }

}