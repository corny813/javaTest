package javaTest;

import java.util.BitSet;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumTest {

	public static void main(String args[]){
		Light l = Light.RED;
		int len = Light.values().length;
		
//		BitSet bs = new BitSet();
//		int size = bs.size();
//		System.out.println(size);
		
		swap(3,10);
		
		EnumMap<Light,String> em = new EnumMap<Light, String>(Light.class);
		em.put(Light.RED, "red light");
		em.put(Light.GREEN, "green light");
		em.put(Light.YELLOW, "yellow light");
		
		EnumSet<Light> es = EnumSet.allOf(Light.class);
		
		System.out.println(l.toString()+" len:"+len);
		System.out.println("em:"+em.size()+" es:"+es.size());
	}
	
	public static void swap(int a,int b){
		System.out.println(a+":"+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+":"+b);
	}
	
}

enum Light{
	RED(1),GREEN(2),YELLOW(3);
	
	int code;
	Light(int code){
		this.code=code;
	}
}