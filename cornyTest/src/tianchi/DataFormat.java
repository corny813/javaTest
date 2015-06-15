package tianchi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFormat {

	BufferedReader br;
	BufferedWriter bw;
	FileReader fr;

	public static void main(String[] args) {
		DataFormat df = new DataFormat();
		String dir = "C:\\Users\\corny\\Desktop\\bigData\\";
		File srcFile = new File(dir+"tianchi_mobile_recommend_train_user.csv");
		File desFile = new File(dir+"user.csv");
		File oneDayFile1218 = new File(dir+"1218.csv"); 

		df.appendTimeFormat(srcFile,desFile);
		df.extractOneDayData(desFile,"2014-12-18",oneDayFile1218);

		df.BufferClose();
	}

	public void InitReader(File srcFile){
		try {
			fr = new FileReader(srcFile);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void appendTimeFormat(File srcFile,File desFile) {
		try {
			InitReader(srcFile);
			bw = new BufferedWriter(new FileWriter(desFile));
			String tmp;
			while ((tmp = br.readLine()) != null) {
				bw.append(tmp + ":00:00\n");
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void extractOneDayData(File srcFile,String date,File desFile){
		if(br!=null){
			String tmp;
			String[] userInfo;
			try {
				InitReader(srcFile);
				bw = new BufferedWriter(new FileWriter(desFile));
				while((tmp=br.readLine())!=null){
					userInfo = tmp.split(",");
					String[] dateTime = userInfo[5].split("[\\s]");
//					System.out.println("date:"+dateTime[0]);
					if(date.equals(dateTime[0])){
						bw.append(tmp+"\n");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("br is null");
		}
	}

	public void BufferClose() {
		try {
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
