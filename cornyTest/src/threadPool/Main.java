package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * �����̳߳� newCachedThreadPool ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
 * 
 * newFixedThreadPool ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ���
 * 
 * newScheduledThreadPool ����һ�������̳߳أ�֧�ֶ�ʱ������������ִ�С�
 * 
 * newSingleThreadExecutor ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO,
 * LIFO, ���ȼ�)ִ�С�
 * 
 * @author corny
 * 
 */
public class Main {

	public class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread()+" "+i);
			}
		}
	}

	
	/**
	 * ��ÿ���߳�˯��һ�뱣֤��һ���߳�������ɣ�������ֻ��һ���߳�
	 * ��������6���߳�
	 */
	public static void newCachedThreadPoolTest() {
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i=0;i<1000;i++){
			es.execute(new Main().new MyRunnable());
		}
	}
	
	/**
	 * �̶��̴߳�С
	 */
	public static void newFixedThreadPoolTest(){
		int tNum = Runtime.getRuntime().availableProcessors();
		System.out.println(tNum);
		ExecutorService service = Executors.newFixedThreadPool(tNum);

		int count=0;
		
		for(int i=0;i<10000;i++){
			service.execute(new Main().new MyRunnable());
			count++;
		}
		System.out.println(tNum + ","+ count);
	}
	
	/**
	 * �ӳ١�����ִ���߳�����
	 */
	public static void newScheduledThreadPoolTest(){
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
//		service.schedule(new Main().new MyRunnable(), 3, TimeUnit.SECONDS);//�ӳ�3��
		service.scheduleAtFixedRate(new Main().new MyRunnable(), 1, 1, TimeUnit.SECONDS);//�ӳ�����
	}

	public static void main(String[] args) {
		newCachedThreadPoolTest();
//		newFixedThreadPoolTest();
//		newScheduledThreadPoolTest();
	}
}
