package javaTest;

public class InnerClassTest {
	
	public static void main(String args[]){
		Outer outer = new Outer();
		outer.print();
	}
}

class Outer{
	Outer(){
		System.out.println("outer..");
	}
	private class Inner{
		Inner(){
			System.out.println("inner..");
		}
	}
	public void print(){
		new Inner();
	}
}
