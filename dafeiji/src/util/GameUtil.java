package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//游戏开发中常用工具类（图片加载等）
public class GameUtil {
	
	private GameUtil(){}//工具类将构造器私有；
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return img;
	}
}
