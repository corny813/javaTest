package crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class SearchByBaidu {

	public static void main(String[] args){
		SearchByBaidu sbb = new SearchByBaidu();
		String keyword = "corny";
		sbb.search(keyword);
	}

	private void search(String keyword) {
		try {
			URL url = new URL("http://www.baidu.com/s?wd="+keyword+"&pn=1");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));
			String tmp = "";
			StringBuilder sb = new StringBuilder();
			while((tmp=br.readLine())!=null){
//				System.out.println(tmp);
				sb.append(tmp+"\n");
			}
//			fw.append(sb);//filewriter can not set the charset
//			fw.close();
			bw.append(sb);
			bw.flush();
			bw.close();
			System.out.println(sb.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
