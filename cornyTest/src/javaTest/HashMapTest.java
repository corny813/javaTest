package javaTest;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String args[]){
		HashMap map = new HashMap();
		IdentityHashMap idenMap = new IdentityHashMap();
		IdentityHashMap iMap2=new IdentityHashMap();
		
		String keys[] ={"key1","key2"};
		
		map.put(new String("key"+1), "value1");
		map.put("key"+2, "value2");
		map.put(new String("key"+1), "value3");
		
		idenMap.put(new String(keys[0]), "value1");
		idenMap.put("key2", "value2");
		idenMap.put(new String(keys[0]), "value3");
		
		iMap2.putAll(idenMap);
		
		Iterator iter=iMap2.entrySet().iterator();
		while(iter.hasNext()){
			Entry entry= (Entry) iter.next();
			System.out.println(entry);
		}
		
	}
}
