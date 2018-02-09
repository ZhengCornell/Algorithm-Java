package refer;

import java.util.EnumMap;

//键必须为枚举
public class EnumMapDemo {

	public static void main(String[] args) {
		EnumMap<Season,String> m = new EnumMap<Season,String>(Season.class);
			//存放
			m.put(Season.SPRING,"chun");
			m.put(Season.SUMMER,"xia");
			m.put(Season.AUTUMN,"qiu");
			m.put(Season.WINTER,"dong");
			System.out.print(m);
		

	}

}
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}
