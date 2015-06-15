package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 四种线程池 newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * 
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * 
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO,
 * LIFO, 优先级)执行。
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
	 * 让每个线程睡眠一秒保证上一个线程任务完成，则整个只有一个线程
	 * 否则会产生6个线程
	 */
	public static void newCachedThreadPoolTest() {
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i=0;i<1000;i++){
			es.execute(new Main().new MyRunnable());
		}
	}
	
	/**
	 * 固定线程大小
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
	 * 延迟、周期执行线程任务
	 */
	public static void newScheduledThreadPoolTest(){
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
//		service.schedule(new Main().new MyRunnable(), 3, TimeUnit.SECONDS);//延迟3秒
		service.scheduleAtFixedRate(new Main().new MyRunnable(), 1, 1, TimeUnit.SECONDS);//延迟周期
	}

	public static void main(String[] args) {
		newCachedThreadPoolTest();
//		newFixedThreadPoolTest();
//		newScheduledThreadPoolTest();
	}
}
