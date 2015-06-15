package javaTest;

public class TestEnum {

	public static void main(String args[]){
		
		Season season = Season.spring;
		switch(season){
		case spring:
			System.out.println("spring");
			break;
		case summer:
			System.out.println("summer");
			break;
		case autumn:
			System.out.println("autumn");
			default:
				System.out.println("winter");
		}
		
		
	}
	
	public enum Season{
		spring,summer,autumn,winter
	}
}
