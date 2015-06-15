/**
 * Java�е�getResourceAsStream�����¼��֣� 
 * 
1. Class.getResourceAsStream(String path): path����'/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ,��'/'��ͷ���Ǵ�
ClassPath���»�ȡ����ֻ��ͨ��path����һ������·��,���ջ�����ClassLoader��ȡ��Դ��

2. Class.getClassLoader.getResourceAsStream(String path): Ĭ�����Ǵ�ClassPath���»�ȡ��path������'/'��ͷ,
��������ClassLoader��ȡ��Դ��
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

	// �ļ������·����������ڹ��̵ĸ�Ŀ¼���Եģ�������Ҳ����ļ�·��
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

		// ����'/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ����'/'��ͷ���Ǵ�ClassPath���»�ȡ
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
