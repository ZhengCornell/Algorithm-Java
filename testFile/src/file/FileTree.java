package file;

import java.io.File;

public class FileTree {

	public static void main(String[] args) {
		File f = new File("/Users/Gz/Desktop/eclipse/testDate/src");
		printFile(f,0);
	}
	static void printFile(File f, int level){
		for(int i = 0; i < level; i ++){
			System.out.print("-");
		}
		System.out.println(f.getName());
		
			if(f.isDirectory()){
				File[] k = f.listFiles();
				for(File temp : k){
					printFile(temp,level+1);
				}
			}
		}
}

