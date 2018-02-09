package URL;

import java.net.MalformedURLException;
import java.net.URL;

public class Build {

	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构建
		URL url = new URL("http://www.google.com:80/index.html#aa?uname=bjsxt");//对内锚点
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getPath());
		System.out.println(url.getRef());//锚点
		System.out.println(url.getQuery());//参数，在有锚点时候为空
		
		//相对路径构建
//		url = new URL("http://www.google.com:80/a/");
//		url = new URL(url,"b.txt");
//		System.out.println(url.toString());
		
	}

}
