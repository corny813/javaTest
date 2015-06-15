package memcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Iterator;

import net.spy.memcached.MemcachedClient;

public class TestMc {

	public static int NUM = 100*10000;

	public static void main(String[] args) throws IOException {
		String ip = "219.223.243.73";
		int port = 12122;
		String key = "oo";

		String ip1 = "192.168.2.129";
		int port1 = 5001;
		String key1 = "pp";

		String ip2 = "192.168.2.130";
		int port2 = 5002;
		String key2 = "qq";

		MemcachedClient cache = new MemcachedClient(new InetSocketAddress(ip,port));

//		MemcachedClient cache1 = new MemcachedClient(new InetSocketAddress(ip1,port1));
		// MemcachedClient cache2 = new MemcachedClient(new
		// InetSocketAddress(ip2,port2));

		 long begin = System.currentTimeMillis();

		 for (int i = 1; i <= NUM; i++) {
		 if (i < NUM / 3) {
		 cache.set(key + i, 3600, key + i);
//		 cache1.set(key + i, 3600, key + i);
		 } else if (i < 2* NUM / 3) {
		 cache.set(key1 + i, 3600, key1 + i);
//		 cache1.set(key1 + i, 3600, key1+i);
		 }
		 else {
		 cache.set(key2 + i, 3600, key2 + i);
//		 cache1.set(key2 + i, 3600, key2 + i);
		 }
//		 cache1.set(key + i, 3600, key + i);
		 
//		 cache1.set(key2 + i, 3600, key+i);
//		 cache2.set(key2 + i, 3600, key2+i);

		 if (i % 100000 == 0) {
		 long end = System.currentTimeMillis();
		 System.out.println((end - begin));
		 begin = end;
		 }
		 }

		// begin=System.currentTimeMillis();
		// for (int i = 1; i <= NUM; i++) {
		// // cache1.set(key1 + i, 3600, key1+i);
		// cache1.set(key + i, 3600, key+i);
		// if(i%100000==0){
		// long end = System.currentTimeMillis();
		// System.out.println((end-begin));
		// begin=end;
		// }
//		 }

//		long begin = System.currentTimeMillis();
//
		for (int i = 1; i <= NUM; i++) {
			String value="";
			if (i < NUM / 3) {
				value = (String)cache.get(key + i);
			} else if (i < NUM * 2 / 3) {
				value = (String)cache.get(key1 + i);
			}else{
				value = (String)cache.get(key2+i);
			}
//			System.out.println(value);
//			else {
//				cache.get(key2 + i);
//			}
//			cache.get(key+i);

			if (i % 10000 == 0) {
				long end = System.currentTimeMillis();
				System.out.println((end - begin));
				begin = end;
			}

			//
			// String value1 = (String) cache.get(key1+i);
			// System.out.println(key1+i+"-->"+value1);
			//
			// String value2 = (String) cache.get(key2 + i);
			// System.out.println(key2+i+"-->"+value2);
			//
			// String value3 = (String) cache1.get(key + i);
			// System.out.println(key+i+"-->"+value3);
			//
			// String value11 = (String) cache1.get(key1+i);
			// System.out.println(key1+i+"-->"+value11);
			//
			// String value12 = (String) cache1.get(key2 + i);
			// System.out.println(key2+i+"-->"+value12);

			// String value3 = (String) cache1.get(key2 + i);
			// System.out.println(key2+i+"-->"+value3);

			// String value2 = (String) cache2.get(key2+i);
			// System.out.println(key2+i+"-->"+value2);

		}

		// for(int j=1;j<=NUM;j++){
		// String value3 = (String) cache.get(key1+j);
		// System.out.println(key1+j+"-->"+value3);
		// // String value2 = (String) cache1.get(key+j);
		// // System.out.println(key+j+"-->"+value2);
		// }
		// long end = System.currentTimeMillis();
		// System.out.println((end-begin)+" ms");
		// cache.get("T11");
	}
}