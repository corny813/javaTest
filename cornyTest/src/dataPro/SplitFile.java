package dataPro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitFile {

	public static void main(String args[]) throws IOException {
		SplitFile sf = new SplitFile();
		File inputFile = new File("acc_walk_0315_600.txt");
		String fileName="acc_walk_";
		sf.splitToFiles(inputFile,120, fileName);
	}

	/**
	 * 把大文件split为每个有num行数据的小文件，文件名为fileName0.txt...
	 * @param inputFile
	 * @param num
	 * @param fileName
	 * @throws IOException
	 */
	private void splitToFiles(File inputFile,int num, String fileName) throws IOException {
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = null;
		String tmp = "";
		int count = 0;
		int fileNum = 0;
		while ((tmp = br.readLine()) != null) {
			count++;
//			System.out.println("count: "+count);
			
			if ((count%num)==1) {
				fileNum++;
				if(count!=1){
					System.out.println("count:"+count);
					bw.flush();
				}
				bw = new BufferedWriter(new FileWriter(new File(fileName+ fileNum+".txt")));
			}
			bw.append(tmp + "\n");
		}
		br.close();
		if (bw != null) {
			bw.flush();
			bw.close();
		}
	}
}
