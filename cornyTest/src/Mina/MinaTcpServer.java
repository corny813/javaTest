package Mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @说明 Mina TCP 服务端
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
		System.out.println("TCP服务启动，端口：" + PORT);
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
		System.out.println("收到消息：" + ByteAndStr16.Bytes2HexString(byten));
//		System.out.println("message:"+byten.toString());
		byte[] bts = new byte[10];
		for(int i=0;i<10;i++){
			bts[i] = (byte)i;
		}
		IoBuffer buffer = IoBuffer.allocate(10);
		buffer.put(bts);
		buffer.flip();
		session.write(buffer);
//		// 拿到所有的客户端Session
//		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
//		// 向所有客户端发送数据
//		for (IoSession sess : sessions) {
//			sess.write(buffer);
//		}
	}
	
	public void sessionClosed(IoSession session) throws Exception {
		end=System.currentTimeMillis()-start;
		System.out.println("会话关闭,total time:"+end);
	}
	
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("会话异常");
		super.exceptionCaught(session, cause);
	}
	
	public void messageSent(IoSession iosession, Object obj) throws Exception {
//		System.out.println("服务端消息发送");
		super.messageSent(iosession, obj);
	}
	
	public void sessionCreated(IoSession iosession) throws Exception {
		System.out.println("会话创建");
		super.sessionCreated(iosession);
	}
	
	public void sessionIdle(IoSession iosession, IdleStatus idlestatus)
			throws Exception {
		System.out.println("会话休眠");
		super.sessionIdle(iosession, idlestatus);
	}
	
	public void sessionOpened(IoSession iosession) throws Exception {
		System.out.println("会话打开");
		start=System.currentTimeMillis();
		super.sessionOpened(iosession);
	}
}