package javaTest;

/**
 * volatile��֤ÿ�λ�ȡ�������µ�ֵ�����ܱ�֤ͬ��
 * @author corny
 *
 */
public class VolatileTest {

	private volatile static int count = 0;

	public static void inc() {
		count++;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					inc();
				}
			}).start();
		}
		System.out.println(count);
	}
}
