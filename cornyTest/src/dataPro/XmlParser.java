package dataPro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParser {
	
	private static FileWriter fwriter;

	public static void main(String args[]){
		
		XmlParser xparser = new XmlParser();
		File fileName = new File("acc_jog.xml");
		File desFile = new File("jogResult.txt");
		InitWriter(desFile);
		xparser.extractValueFromNode(fileName);
	}
	
	private static void InitWriter(File file){
		try {
			fwriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void extractValueFromNode(File file) {
		SAXReader reader = new SAXReader();
		StringBuffer sb = new StringBuffer();
		try {
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			Iterator iter = root.elementIterator();//global-->state-->sensor
			while(iter.hasNext()){
				Element state = (Element) iter.next();
//				System.out.println(state.getName());
				Iterator sensorIter = state.elementIterator();
				while(sensorIter.hasNext()){
					Element sensorNode = (Element) sensorIter.next();
					if(sensorNode.attributeValue("type").equals("accelerometer")){
						Iterator valueIter = sensorNode.elementIterator();
						while(valueIter.hasNext()){
							Element value = (Element) valueIter.next();
							String tmp = value.getData()+",";
//							System.out.print(tmp);
							sb.append(tmp.toString());
						}
						sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",")+1, "\n");
					}
					
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
//		System.out.println(sb.toString());
		writeResult(sb.toString());
	}
	
	public void writeResult(String content){
		try {
			fwriter.append(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fwriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
