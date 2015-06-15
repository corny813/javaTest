package mybatis.test;

import junit.framework.TestCase;
import mybatis.jdbc.JDBCOperas;

public class Test extends TestCase{

	JDBCOperas jdbc = new JDBCOperas();
	
	public void selectByIdTest(){
		jdbc.selectById("1");
	}
	
}
