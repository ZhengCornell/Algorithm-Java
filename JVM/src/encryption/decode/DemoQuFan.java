package encryption.decode;

import DIYLCL.FileSystemClassLoader;

public class DemoQuFan {

	public static void main(String[] args) {
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/Gz/Desktop/testjava");

		Class<?> c = loader.findClass("a.java");
		
		
	}

}
