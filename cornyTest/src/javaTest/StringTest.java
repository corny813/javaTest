package javaTest;

public class StringTest {

	public static void main(String[] args) {
		
		//a,a1,a2都存在String常量池中，常量池中常量不重复，所以引用的是同一个对象
		String a = "abc";
		String a1 = "abc";
		String a2 = "a"+"bc";
		
		String b = new String("abc");
		String b1 = new String("abc");
		System.out.println((b==b1)+","+b.equals(b1));
		
		//equals方法代表a,b的内容是否相同，==表明引用的是不是同一个对象
		System.out.println(a.equals(b)+":"+(a==a1)+","+(a==a2)+","+(a==b));
		
		//在栈中开辟一块引用str1，在堆中创建一个对象abc，所以str1和常量池中的abc不==
		String str1 = new String("abc");
		String str2 = "a"+new String("bc");
		System.out.println((str1=="abc")+","+str1.equals("abc")+","+(str2=="abc"));
		
		//当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量
		//如果有，则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用
		String s0 = new String("abc");
		String s1 = s0.intern();
		System.out.println("intern: "+(s1=="abc"));
		
	}
}
