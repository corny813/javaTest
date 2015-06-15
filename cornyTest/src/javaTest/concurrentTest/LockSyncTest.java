package javaTest.concurrentTest;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSyncTest{

	public static void runTasks(Class<? extends Runnable> clz) throws Exception, IllegalAccessException{
		ExecutorService es = Executors.newCachedThreadPool();
		System.out.println("start thread task "+clz.getSimpleName());
		for(int i=0;i<3;i++){
			es.submit(clz.newInstance());
		}
		TimeUnit.SECONDS.sleep(10);
		System.out.println(clz.getSimpleName()+ " end ");
		es.shutdown();
	}
	
	public static void main(String[] args) throws IllegalAccessException, Exception {
		runTasks(TaskWithLock.class);
		runTasks(TaskWithSync.class);
	}
}

class Task{
	public void doSomething(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("thread name: "+Thread.currentThread().getName());
		sb.append(", time: "+Calendar.getInstance().get(Calendar.SECOND)+" s");
		System.out.println(sb.toString());
	}
}

class TaskWithLock extends Task implements Runnable{

	private final Lock lock = new ReentrantLock();
	@Override
	public void run() {
		try{
			lock.lock();
			doSomething();
		}finally{
			lock.unlock();
		}
	}
}

class TaskWithSync extends Task implements Runnable{

	@Override
	public void run() {
		synchronized(""){
			doSomething();
		}
	}
}

