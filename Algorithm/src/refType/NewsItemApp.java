package refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsItemApp {

	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("中国",100,new Date()));
		news.add(new NewsItem("美国",50,new Date(System.currentTimeMillis()+1000)));
		news.add(new NewsItem("日本",20,new Date(System.currentTimeMillis()-1000)));
		System.out.println(news);
//		Collections.sort(news);
		
		System.out.println(news);
	
	}

}
