package properties;

import java.util.Properties;

//资源配置文件读写
//KV must String
public class Demo01 {

	public static void main(String[] args) {
//		创建对象
		Properties pro = new Properties();
//		存储
		pro.setProperty("driver","oracle.jdbc.driver.OracleDriver");
//		pro.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","scott");
		pro.setProperty("pwd","tiger");
		
		String url = pro.getProperty("url","test");
		System.out.println(url);
		
		
		
	}

}
