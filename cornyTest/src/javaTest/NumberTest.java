package javaTest;

public class NumberTest {

	public static void main(String args[]){
//		double num = 1256.22;
//		num = num/100;
//		System.out.println(Math.round(num)*100);
//		
//		float f = (float) 3.4;
//		Float num1 = Float.MAX_VALUE;
//		System.out.println(num1);
		
		
	}
	
	/**
	 * boolean和byte占用空间大小相似：-Xmx10M时，total=7M时溢出，total=6M正常运行
	 */
	public void testBooleanBits(){
		int total = 7*1024*1024;
//		short[] shorts = new short[total];
//		byte[] bytes = new byte[total];
		boolean[] b = new boolean[total];
	}
}
