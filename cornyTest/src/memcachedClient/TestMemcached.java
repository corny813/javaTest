package memcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class TestMemcached {

	public static MemcachedClient cache = null;
	public static int ShiWan = 10*10000;

	public static void main(String[] args) throws IOException {

		cache = new MemcachedClient(
				new InetSocketAddress("192.168.2.129", 5001));

		TestMemcached.tRead tGet = new TestMemcached().new tRead();
//		 tGet.start();

		TestMemcached.tWrite tSet = new TestMemcached().new tWrite();
		TestMemcached.tWrite tSet1 = new TestMemcached().new tWrite();
		tSet.start();
		tSet1.start();
	}

	class tRead extends Thread {

		public void run() {
			for (int i = 1; i < 100 * 10000; i++) {
				cache.get("T1" + i);
			}
		}
	}

	class tWrite extends Thread {
		long begin = System.currentTimeMillis();
		int count=0;
		public void run() {
			for (int i = 1; i < 100*10000; i++) {
				// cache.set("k1" + i, 3600, new Object());
				cache.set(Thread.currentThread().getName()+"T1" + i, 100, "hello corny"+i);
				count++;
				if(count%ShiWan==0){
					long end = System.currentTimeMillis();
					System.out.println((end-begin)+" ms "+Thread.currentThread().getId());
					begin = end;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println((end-begin)+" ms");
		}
	}

}