package properties;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		//类相对路径读取 / 表示找根目录
//		pro.load(Demo04.class.getResourceAsStream("/properties/db.properties"));
		
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/db.properties"));
		System.out.println(pro.getProperty("user","scott"));
	}

}
