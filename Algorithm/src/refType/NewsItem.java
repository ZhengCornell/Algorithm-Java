package refType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements java.lang.Comparable<NewsItem> {
	private String title;
	private int hits;
	private Date pubTime;
	public NewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
 		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public NewsItem(){
		
	}
	
	//时间降，点击量升，标题降
	@Override
	public int compareTo(NewsItem o) {
		int result = 0;
		//比较时间
		result = -this.pubTime.compareTo(o.pubTime);
		if(0==result){//时间相同看点击量
		result = this.hits - o.hits;
		if(0==result){
			result = -this.title.compareTo(o.title);
		}else{
			
		}
		}else{
			
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题：").append(this.title);
		sb.append(",时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.pubTime));
		sb.append(",点击量：").append(this.hits).append("\n");
		
		return sb.toString();
	}
	
}
