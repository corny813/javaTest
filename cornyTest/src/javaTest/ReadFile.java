package javaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String args[]) {

		String filePath = "F:\\TDDOWNLOAD\\ESANN-2013-Competition-userset\\_y_test_ground_truth.txt";

		ReadFile rf = new ReadFile();
		rf.fileInfo(new File(filePath));
	}

	public void fileInfo(File file) {
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String tmp;
			int countColumn = 0;
			int countRow = 0;

			while ((tmp = br.readLine()) != null) {
				countRow++;
				String strs[] = tmp.trim().split("\\s+");
				countColumn = strs.length;
				System.out.println("第 " + countRow + " 行,列数为：" + countColumn);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
