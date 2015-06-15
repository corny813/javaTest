package javaTest;

import java.util.Vector;

public class VectorTest implements Runnable{

	public static void main(String[] args) {
		Vector vec = new Vector();
		vec.add("a");
		vec.add("b");
		int len = vec.size();
	}

	@Override
	public void run() {
		Math.hypot(0.1, 0.2);
	}
}
