package javaTest;

public class ShiftTest {

	public static void main(String[] args){
		int num = 1;
		int num1 = 1;
		
		for(int i=0;i<3;i++){
			num = ((num<<1) + 1);
			System.out.print(num+" ");
			
			num1 = num1<<1;
			num1 = (num1 + 1);
			System.out.print(num1+" ");
			System.out.println();
		}
	}
}
