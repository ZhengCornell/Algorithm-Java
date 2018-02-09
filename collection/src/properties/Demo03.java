package properties;
//写一次读多次
//load(InputStream inStream)
//load(Reader reader)
//loadFromXML(InputStream in)

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo03 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//读取 绝对路径
		pro.load(new FileReader("/Users/Gz/Desktop/java/db.properties"));
		
		System.out.println(pro.getProperty("user","scott"));
		//读取 相对路径
		pro.load(new FileReader("db.properties"));
		
		System.out.println(pro.getProperty("dirver","oracle.jdbc.driver.OracleDriver"));
	}

}
