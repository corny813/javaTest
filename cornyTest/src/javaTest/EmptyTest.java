package javaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造一个无任何字段的空对象占多少内存
 * 
 * @author
 */

public class EmptyTest {

	public static void main(String[] args) throws InterruptedException{
		
        //加到集合中，使垃圾无法回收
        List<EmptyObject> emptys = new ArrayList<EmptyObject>();
        
        for(int i=0;i<100;i++){
            emptys.add(new EmptyObject());
        }
        
        //打开jvisualvm,查看EmptyObject的大小为16字节
        Thread.sleep(60*1000);
    }

	private static class EmptyObject {
	}
}