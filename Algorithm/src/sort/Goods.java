package sort;

import java.text.SimpleDateFormat;

//不实现任何接口
public class Goods {
	private double price;
	private int fav;
	private String name;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Goods(double price, int fav, String name) {
		super();
		this.price = price;
		this.fav = fav;
		this.name = name;
	}
	public Goods(){
		
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题：").append(this.name);
		sb.append(",价格").append(this.price);
		sb.append(",热度：").append(this.fav);
		
		return sb.toString();
	}
	
}
