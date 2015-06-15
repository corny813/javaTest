package javaTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		Class<?> cla = Class.forName("javaTest.Car");//包的完整限定名,否则报错
		Object obj = cla.newInstance();
		Method method = cla.getMethod("move");
		method.invoke(obj);
		
		Method method2 = cla.getMethod("start", String.class);
		method2.invoke(obj, "hu nan");
		
		Method method3 = cla.getMethod("add", int.class, int.class);
		method3.invoke(obj, 2, 5);
		
		Method method4 = cla.getMethod("print", int.class,int.class,String.class);
		method4.invoke(obj, 8,8,"");
		
		System.out.println(8+8+"");//output: 16
		System.out.println(""+8+8);//output: 88
	}
}

class Car{
	String brand;
	
	public void move(){
		System.out.println("car moving...");
	}
	
	public void start(String des){
		System.out.println("go to "+des);
	}
	
	public void add(int a,int b){
		System.out.println(a+b);
	}
	
	public void print(int a,int b,String msg){
		System.out.println(a+b+msg+a+b);
	}
	
}