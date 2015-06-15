package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

	public static void main(String args[]) throws IOException {
		
		String name = "apple";
		String fileName = "src/factory/fruit.properties";
		
		Properties prop = init(fileName);
		String className = prop.getProperty(name);
		
		try {
			Fruit fruit = (Fruit) Factory.getInstance(className);
			if (fruit != null) {
				fruit.eat();
			}
		} catch (InstantiationException e) {
			System.out.println("instantiation fail");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("illegal access");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
	}
	
	public static Properties init(String fileName) throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File(fileName));
		prop.load(fis);
		fis.close();
		return prop;
	}
}
