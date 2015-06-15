package dataPro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtToArff {

	public static void main(String args[]) throws IOException{
		
		TxtToArff tta = new TxtToArff();
		
		File importFile = new File("mean_std.txt");
		File outputFile = new File("test.txt");
		
		tta.txtFormat(importFile,outputFile);
//		tta.transToArff(outputFile);
	}

	private void transToArff(File outputFile) {
		
	}

	/**
	 * 
	 * @param importFile
	 * @throws IOException 
	 */
	private void txtFormat(File importFile,File outputFile) throws IOException {
		try {
			FileReader fr = new FileReader(importFile);
			BufferedReader br = new BufferedReader(fr);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			
			String tmp="";
			while((tmp=br.readLine())!=null){
//				String[] strs = tmp.split("\\s");
				tmp = tmp.replaceAll("\\s+", ",");
				bw.append(tmp);
				bw.append("\n");
			}
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
