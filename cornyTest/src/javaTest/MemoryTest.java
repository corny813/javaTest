package javaTest;

import java.util.ArrayList;
import java.util.List;

public class MemoryTest {

	public static void main(String args[]) throws InterruptedException {
		DataObject obj;
		int num = 10000*10000;

		List<DataObject> datas = new ArrayList<DataObject>();
		
		while (num-- > 0) {
			obj = new DataObject();
			datas.add(obj);
			
			if(num%1000==0){
				Thread.sleep(10);
			}
		}
		
		System.out.println(datas.size());
	}
}
