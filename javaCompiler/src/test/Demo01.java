package test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {

	public static void main(String[] args) throws IOException {
		String str = "public class Hi{public static void main(String args[]){System.out.println(\"worinige\");}}";
		JavaCompiler c = ToolProvider.getSystemJavaCompiler();
		int result = c.run(null,null,null,"/Users/Gz/Desktop/testjava/d.java");
		
		File dest = new File("/Users/Gz/Desktop/testjava/Hi.java");
		byte[] data = str.getBytes();
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		bos.write(data);
		bos.flush();
		bos.close();
		System.out.println(dest.getPath());
		int result1 = c.run(null,null,null,dest.getPath());//用IO流存成临时文件
		System.out.println(result==0?"成功":"失败");
		System.out.println(result1==0?"成功":"失败");
		
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp  /Users/Gz/Desktop/testjava  Hi");
		InputStream is = process.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info ="";
		while(null!=(info = br.readLine())){
			System.out.println(info);
		}
	}

}
