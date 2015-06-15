/**
 * Java中的getResourceAsStream有以下几种： 
 * 
1. Class.getResourceAsStream(String path): path不以'/'开头时默认是从此类所在的包下取资源,以'/'开头则是从
ClassPath根下获取。其只是通过path构造一个绝对路径,最终还是由ClassLoader获取资源。

2. Class.getClassLoader.getResourceAsStream(String path): 默认则是从ClassPath根下获取，path不能以'/'开头,
最终是由ClassLoader获取资源。
 *
 */

package javaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class Configure {

	public static void main(String args[]) throws IOException {
		Configure conf = new Configure();

		// conf.getSystemProperty();

		conf.getPropertyFromFile();
		conf.readPropertyFile();
	}

	public void getSystemProperty() {
		Properties props = new Properties();
		props = System.getProperties();
		String path = props.getProperty("user.dir");
		System.out.println("path: " + path);
		Iterator iter = props.entrySet().iterator();

		while (iter.hasNext()) {
			String temp = iter.next().toString();
			if (temp.contains("user")) {
				System.out.println(temp);
			}
		}
	}

	public void getProjectRoot() {

	}

	// 文件的相对路径都是相对于工程的根目录而言的，否则会找不到文件路径
	public void readPropertyFile() throws IOException {

		FileInputStream fis = new FileInputStream(new File(
				"kairosdb.properties"));
		Properties props = new Properties();
		props.load(fis);
		configure(props);
		fis.close();
	}

	public void getPropertyFromFile() throws IOException {
		Properties props = new Properties();

		// 不以'/'开头时默认是从此类所在的包下取资源，以'/'开头则是从ClassPath根下获取
		InputStream is = getClass().getResourceAsStream("kairosdb.properties");
		props.load(is);
		is.close();
		configure(props);
	}

	public void configure(Properties prop) {
		String hostname = prop.getProperty("kairosdb.service.telnet");
		String port = prop.getProperty("kairosdb.telnetserver.port");
		System.out.println(hostname + ":" + port);
	}
}
