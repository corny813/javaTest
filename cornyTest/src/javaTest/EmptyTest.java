package javaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����κ��ֶεĿն���ռ�����ڴ�
 * 
 * @author
 */

public class EmptyTest {

	public static void main(String[] args) throws InterruptedException{
		
        //�ӵ������У�ʹ�����޷�����
        List<EmptyObject> emptys = new ArrayList<EmptyObject>();
        
        for(int i=0;i<100;i++){
            emptys.add(new EmptyObject());
        }
        
        //��jvisualvm,�鿴EmptyObject�Ĵ�СΪ16�ֽ�
        Thread.sleep(60*1000);
    }

	private static class EmptyObject {
	}
}