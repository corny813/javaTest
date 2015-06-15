package dataPro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteBeginData {

	public static void main(String[] args){
		String dir = "C:\\Users\\corny\\Desktop\\testDatas";
		File[] files = new File(dir).listFiles();
		
		for(File f : files){
			deleteBeginData(f,500);
		}
	}
	
	/**
	 * 删除文件前500的数据，保留501到最后
	 * @param file
	 * @param num
	 */
	public static void deleteBeginData(File file ,int num){
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String newName = file.getParent()+"\\"+file.getName().substring(5);
			FileWriter fw = new FileWriter(newName);;
			String tmp = "";
			int i=0;
			while((tmp=br.readLine())!=null){
				i++;
				if(i>num){
					fw.append(tmp+"\n");
				}
			}
			fw.flush();
			br.close();
			fw.close();
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
