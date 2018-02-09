package io.chario;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharCopy {

	public static void main(String[] args) {
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a.rtf");
		File dest = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/K.java");
		Reader r = null;
		Writer w = null;
		try {
			r = new FileReader(src);
			w = new FileWriter(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] flush = new char[1024];
		int len = 0;
		try {
			while(-1 != (len = r.read(flush))){
				w.write(flush, 0, len);
			}
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
				try {
					if(null != w)
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(null != r){
					try {
						r.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}

}
