package Mina;

import java.net.InetSocketAddress;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @˵�� Mina TCP�ͻ���
 * @version 1.0
 * @since
 */
public class MinaTcpClient extends IoHandlerAdapter implements Runnable {
	private IoConnector connector;
	private static IoSession session;
	private static int NUM = 10 * 10000;
	private static int tNUM = 10;

	public MinaTcpClient() {
		connector = new NioSocketConnector();
		connector.setHandler(this);
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(
				"localhost", MinaTcpServer.PORT));
		connFuture.awaitUninterruptibly();
		session = connFuture.getSession();
		System.out.println("TCP �ͻ�������");
	}

	public static void main(String[] args) throws Exception {
		MinaTcpClient client = new MinaTcpClient();
		
		long begin = System.currentTimeMillis();
		
		for (int i = 0; i < tNUM; i++) {
			Thread t = new Thread(client);
			t.start();
		}
		long time = System.currentTimeMillis()-begin;
		System.out.println(time);
	}

	public void run() {
		MinaTcpClient client = new MinaTcpClient();

//		long begin = System.currentTimeMillis();

		for (int j = 0; j < NUM; j++) { // ��������
			byte[] bts = new byte[20];
			// for (int i = 0; i < 20; i++) {
			// bts[i] = (byte) i;
			// }
			int id = 141592653;
			double time = System.currentTimeMillis();
			double tag_val = 3.14159265358;
			String message = id + "" + time + "" + tag_val
					+ "key:sdfsdabsdfsfdfsdfsdfsdfghjk";

			IoBuffer buffer = IoBuffer.allocate(20);
			// �Զ�����
			buffer.setAutoExpand(true);
			// �Զ�����
			buffer.setAutoShrink(true);
			// buffer.put(bts);
			buffer.put(message.getBytes());
			buffer.flip();
			session.write(buffer);
			// Thread.sleep(2000);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		long end = System.currentTimeMillis() - begin;
//		System.out.println(end + " ms");
		// �رջỰ���������̴߳��������
		client.connector.dispose(true);
	}

	
	public void messageReceived(IoSession iosession, Object message)
			throws Exception {
		IoBuffer bbuf = (IoBuffer) message;
		byte[] byten = new byte[bbuf.limit()];
		bbuf.get(byten, bbuf.position(), bbuf.limit());
		// System.out.println("�ͻ����յ���Ϣ" + ByteAndStr16.Bytes2HexString(byten));
	}

	
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("�ͻ����쳣");
		super.exceptionCaught(session, cause);
	}

	
	public void messageSent(IoSession iosession, Object obj) throws Exception {
		// System.out.println("�ͻ�����Ϣ����");
		super.messageSent(iosession, obj);
	}

	
	public void sessionClosed(IoSession iosession) throws Exception {
		System.out.println("�ͻ��˻Ự�ر�");
		super.sessionClosed(iosession);
	}

	
	public void sessionCreated(IoSession iosession) throws Exception {
		System.out.println("�ͻ��˻Ự����");
		super.sessionCreated(iosession);
	}

	
	public void sessionIdle(IoSession iosession, IdleStatus idlestatus)
			throws Exception {
		System.out.println("�ͻ��˻Ự����");
		super.sessionIdle(iosession, idlestatus);
	}

	
	public void sessionOpened(IoSession iosession) throws Exception {
		System.out.println("�ͻ��˻Ự��");
		super.sessionOpened(iosession);
	}

}
