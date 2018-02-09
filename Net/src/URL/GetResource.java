package URL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

//获取资源
public class GetResource {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");//这是主页，默认资源
//		//获取资源
//		InputStream is = url.openStream();
//		byte[] flush = new byte[1024];
//		int len = 0;
//		while(-1 != (len = is.read(flush))){
//			System.out.println(new String(flush,0,len));
//		}
//		is.close();
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("kk"),"GBK"));
		String str = null;
		while(null != (str = br.readLine())){
			bw.append(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
