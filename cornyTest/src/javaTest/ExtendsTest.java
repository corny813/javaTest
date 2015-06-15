package javaTest;

public class ExtendsTest {
	
	public static void main(String args[]){
		new Child();
		new Child();
	}
}

class Father{
	static{
		System.out.println("1");
	}
	public Father(){
		System.out.println("father...");
	}
}

class Child extends Father{
	static{
		System.out.println("2");
	}
	public Child(){
		System.out.println("child...");
	}
}