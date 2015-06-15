package javaTest;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class TcpClient extends AbstractJavaSamplerClient implements IoHandler,Runnable {
	// Sock begin----------------------------------------------
	private Socket sid;
	private PrintWriter out;
	private BufferedReader in;
	private String ip;
	private String port;
	// Sock end------------------------------------------------

	private IoConnector connector;
	private static IoSession session;
	private boolean received = false;
	public static final int MAX_RECEIVED = 100000;
	
	private static int tNUM=1;

	private static String label = "howsky.net";

	// 测试结果
	private SampleResult sr;

	/**
	 * 初始化
	 */
	public void setupTest(JavaSamplerContext arg0) {
		System.out.println("setupTest");
	}

	/**
	 * 设置请求的参数
	 */
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		// params.addArgument("ip", "192.168.0.18");
		// params.addArgument("port", "8088");

		params.addArgument("ip", "127.0.0.1");
		params.addArgument("port", "18567");

		return params;
	}

	public TcpClient() {
		connector = new NioSocketConnector();

		connector.setHandler(this);
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(
				"localhost", 18567));

		connFuture.awaitUninterruptibly();

		session = connFuture.getSession();
	}

	public void startNow() throws Exception{
		 TcpClient client = new TcpClient();

	        long t0 = System.currentTimeMillis();

	        for (int i = 0; i <= MAX_RECEIVED; i++) {
	            IoBuffer buffer = IoBuffer.allocate(100);
//	            buffer.putInt(i);
	            int id = 141592653;
				double time = System.currentTimeMillis();
				double tag_val = 3.14159265358;
				String message = id + "" + time + "" + tag_val
						+ "key:sdfsdabsdfsfdfsdfsdfsdfghjk";
				buffer.put(message.getBytes());
	            buffer.flip();
	            session.write(buffer);

	            while (client.received == false) {
	                Thread.sleep(1);
	            }
	            client.received = false;
	            if (i % 10000 == 0) {
	                System.out.println("Sent " + i + " messages");
	            }
	        }
	        long t1 = System.currentTimeMillis();
	        System.out.println("Sent messages delay : " + (t1 - t0));
	        Thread.sleep(2000);
	        client.connector.dispose(true);
	}
	
	public void run() {
		for(int i=0;i<tNUM;i++){
			try {
				startNow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		TcpClient tcp = new TcpClient();
		try {
//			tcp.startNow();
			Thread t = new Thread(tcp);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 运行过程
	 */
	public SampleResult runTest(JavaSamplerContext arg0) {
//		ip = arg0.getParameter("ip");
//		port = arg0.getParameter("port");
	
		sr = new SampleResult();
		sr.sampleStart();
//		sr.setSampleLabel(label);
		try {
//			startNow();
			TcpClient client = new TcpClient();
			Thread t = new Thread(client);
			t.start();
//			sr.sampleStart(); // 记录程序执行时间，以及执行结果
			// 发送数据
//			String msg = "welcome to howsky.net";
//			System.out.println("begin");
//			sendMsg(ip, Integer.parseInt(port), msg);
//			start();
			sr.setSuccessful(true);
//			System.out.println("end");
		} catch (Throwable e) {
			sr.setSuccessful(false);
		} finally {
			sr.sampleEnd();
		}
		return sr;
	}

	/**
	 * 结束
	 */
	public void teardownTest(JavaSamplerContext arg0) {
	}

	private void sendMsg(String ip, int port, String msg) throws Exception {
		connector = new NioSocketConnector();
		connector.setHandler(this);
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(ip,
				port));
		connFuture.awaitUninterruptibly();

		session = connFuture.getSession();

		TcpClient client = new TcpClient();
		long t0 = System.currentTimeMillis();

		for (int i = 0; i <= MAX_RECEIVED; i++) {
			IoBuffer buffer = IoBuffer.allocate(4);
			buffer.putInt(i);
			// buffer.put(msg.getBytes());
			buffer.flip();
			session.write(buffer);

			while (client.received == false) {
				Thread.sleep(1);
			}

			client.received = false;

			if (i % 10000 == 0) {
				System.out.println("Sent " + i + " messages");
			}
		}

		long t1 = System.currentTimeMillis();

		System.out.println("Sent messages delay : " + (t1 - t0));

		Thread.sleep(10000);

		client.connector.dispose(true);

		// sid = new Socket(ip, port);
		// in = new BufferedReader(new InputStreamReader(sid.getInputStream()));
		// out = new PrintWriter(sid.getOutputStream(), true);
		// out.println(msg);
		// in.readLine();
		// System.out.println("success");
		// Thread.sleep(1000);
	}

	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		cause.printStackTrace();
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		received = true;
	}

	public void sessionCreated(IoSession session) throws Exception {
	}

	public void sessionOpened(IoSession session) throws Exception {
	}

	public void sessionClosed(IoSession session) throws Exception {
	}

	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
	}

	
	public void messageSent(IoSession session, Object message) throws Exception {
	}

	public void inputClosed(IoSession session) throws Exception {
	}

}