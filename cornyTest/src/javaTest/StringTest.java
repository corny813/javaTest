package javaTest;

public class StringTest {

	public static void main(String[] args) {
		
		//a,a1,a2������String�������У��������г������ظ����������õ���ͬһ������
		String a = "abc";
		String a1 = "abc";
		String a2 = "a"+"bc";
		
		String b = new String("abc");
		String b1 = new String("abc");
		System.out.println((b==b1)+","+b.equals(b1));
		
		//equals��������a,b�������Ƿ���ͬ��==�������õ��ǲ���ͬһ������
		System.out.println(a.equals(b)+":"+(a==a1)+","+(a==a2)+","+(a==b));
		
		//��ջ�п���һ������str1���ڶ��д���һ������abc������str1�ͳ������е�abc��==
		String str1 = new String("abc");
		String str2 = "a"+new String("bc");
		System.out.println((str1=="abc")+","+str1.equals("abc")+","+(str2=="abc"));
		
		//��һ��Stringʵ��str����intern()����ʱ��Java���ҳ��������Ƿ�����ͬUnicode���ַ�������
		//����У��򷵻�������ã����û�У����ڳ�����������һ��Unicode����str���ַ�����������������
		String s0 = new String("abc");
		String s1 = s0.intern();
		System.out.println("intern: "+(s1=="abc"));
		
	}
}
