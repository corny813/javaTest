package javaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SplitFile {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"Aggregation.txt")));

		String line = null;

		String str = "¹Ø¼ü´Ê1  ¹Ø¼ü´Ê2  ¹Ø¼ü´Ê3";
		String[] words = str.split(" ");
		for (String word : words) {
			System.out.println(word);
		}

		// int count =0;

		while ((line = br.readLine()) != null) {
			String[] ss = line.split("  ");

			// char[] s =line.toCharArray();

			System.out.println(ss.length);
			for (int i = 0; i < ss.length; i++) {
				System.out.print(ss[i]);
				// System.out.println(""+s[i]);
			}
		}
	}

}
