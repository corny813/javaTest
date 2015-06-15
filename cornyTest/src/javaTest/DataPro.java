package javaTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class DataPro {

	/**
	 * metric, timestamp, value, tags
	 */
	
	public static void main(String args[]){
		
		String filePath="d:/data2000w.txt";
		long start = System.currentTimeMillis();
		dataPro(20,1000,1000,new File(filePath));
		long time = System.currentTimeMillis()-start;
		System.out.println(time);
	}

	/**
	 * 
	 * @param metricNum
	 * @param timeNum
	 * @param tagsNum
	 */
	private static void dataPro(int metricNum, int timeNum, int tagsNum,File file) {
		int value;
		String metric;
		long timestamp;
		String tag;
		FileWriter fw;
		
		try {
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0;i<metricNum;i++){
				metric="sys.cpu"+i;
				for(int j=0;j<timeNum;j++){
					timestamp=1356998400+j;
					for(int k=0;k<tagsNum;k++){
						tag="tag=tag"+"_"+k;
						value=new Random().nextInt(10000);
//						System.out.println(metric+" "+timestamp+" "+value+" "+tag);
						String data = metric+" "+timestamp+" "+value+" "+tag;
						bw.append(data+"\n");
					}
				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
