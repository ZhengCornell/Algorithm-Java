package properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//使用property输出到文件
//资源配置文件，可以随时切换数据库
//用store(Writer writer,String comments)'
//store(OutputStream out, String comments)
//storeToXML(OutputStream os, String comment)
//storeToXML(OutputStream os, String comment,String encoding)
public class Demo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		创建对象
		Properties pro = new Properties();
//		存储
		pro.setProperty("driver","oracle.jdbc.driver.OracleDriver");
//		pro.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","scott");
		pro.setProperty("pwd","tiger");
		
		//存储到e:/others 绝对路径 盘符
//		与外界存在联系，要用检查时异常
//		pro.store(new FileOutputStream(new File("/Users/Gz/Desktop/java/db.properties")),"db配置");
//		pro.storeToXML(new FileOutputStream(new File("/Users/Gz/Desktop/java/dkb.xml")),"XML配置");
		//使用相对路径 默认当前工程project
//		pro.store(new FileOutputStream(new File("db.properties")),"db配置");
		pro.store(new FileOutputStream(new File("src/properties/db.properties")),"db配置");

	}
}
