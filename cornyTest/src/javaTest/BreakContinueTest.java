package javaTest;

public class BreakContinueTest {

	public static void main(String[] args){
		
		int iTotal = 10;
		int jTotal = 5;
		int count = 0;
		
		for(int i=1;i<iTotal;i++){
			
			for(int j=1;j<jTotal;j++){
				
				if(i%j==0){
					System.out.println("i,j:"+i+","+j);
					break;
				}
			}
			count++;
			System.out.println(i+",count:"+count);
		}
//		System.out.println(count);
	}
}
