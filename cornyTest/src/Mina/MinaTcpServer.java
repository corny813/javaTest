package Mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @˵�� Mina TCP �����
 * @version 1.0
 * @since
 */
public class MinaTcpServer extends IoHandlerAdapter {
	public static final int PORT = 18567;
	long start=0;
	long end=0;
	
	public MinaTcpServer() throws IOException {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.setHandler(this);
		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("TCP�����������˿ڣ�" + PORT);
	}
	public static void main(String[] args) throws IOException {
//		long begin = System.currentTimeMillis();
		new MinaTcpServer();
//		long time = System.currentTimeMillis()-begin;
//		System.out.println(time);
	}
	
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		IoBuffer bbuf = (IoBuffer) message;
		byte[] byten = new byte[bbuf.limit()];
		bbuf.get(byten, bbuf.position(), bbuf.limit());
		System.out.println("�յ���Ϣ��" + ByteAndStr16.Bytes2HexString(byten));
//		System.out.println("message:"+byten.toString());
		byte[] bts = new byte[10];
		for(int i=0;i<10;i++){
			bts[i] = (byte)i;
		}
		IoBuffer buffer = IoBuffer.allocate(10);
		buffer.put(bts);
		buffer.flip();
		session.write(buffer);
//		// �õ����еĿͻ���Session
//		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
//		// �����пͻ��˷�������
//		for (IoSession sess : sessions) {
//			sess.write(buffer);
//		}
	}
	
	public void sessionClosed(IoSession session) throws Exception {
		end=System.currentTimeMillis()-start;
		System.out.println("�Ự�ر�,total time:"+end);
	}
	
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("�Ự�쳣");
		super.exceptionCaught(session, cause);
	}
	
	public void messageSent(IoSession iosession, Object obj) throws Exception {
//		System.out.println("�������Ϣ����");
		super.messageSent(iosession, obj);
	}
	
	public void sessionCreated(IoSession iosession) throws Exception {
		System.out.println("�Ự����");
		super.sessionCreated(iosession);
	}
	
	public void sessionIdle(IoSession iosession, IdleStatus idlestatus)
			throws Exception {
		System.out.println("�Ự����");
		super.sessionIdle(iosession, idlestatus);
	}
	
	public void sessionOpened(IoSession iosession) throws Exception {
		System.out.println("�Ự��");
		start=System.currentTimeMillis();
		super.sessionOpened(iosession);
	}
}