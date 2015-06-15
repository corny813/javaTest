package memcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class TestMcMultiThreads {

	public static void main(String args[]) {
		tWrite tw = new tWrite();
		tw.start();
		
		tWrite2 tw2 = new tWrite2();
		tw2.start();
	}
}

class tWrite extends Thread {
	String ip = "192.168.2.128";
	int port = 5000;
	String key = "keyl1";
	public static int NUM = 100*10000;

	public void run() {
		MemcachedClient cache;
		try {
			cache = new MemcachedClient(new InetSocketAddress(ip,port));
			long begin = System.currentTimeMillis();

			for (int i = 1; i <= NUM; i++) {
				cache.set(key + i, 3600, key + i);
				if (i % 100000 == 0) {
					long end = System.currentTimeMillis();
					System.out.println((end - begin));
					begin = end;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class tWrite2 extends Thread {
	String ip = "192.168.2.129";
	int port = 5001;
	String key = "keym1";
	public static int NUM = 100*10000;

	public void run() {
		MemcachedClient cache;
		try {
			cache = new MemcachedClient(new InetSocketAddress(ip,port));
			long begin = System.currentTimeMillis();

			for (int i = 1; i <= NUM; i++) {
				cache.set(key + i, 3600, key + i);
				if (i % 100000 == 0) {
					long end = System.currentTimeMillis();
					System.out.println((end - begin));
					begin = end;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
