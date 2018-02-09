import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point>{
	private final int x;
	private final int y;
	public Point(int x, int y){
		if(x<0 || y<0 || x>32767 || y>32767){
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}
	public void draw(){
		StdDraw.point(x,y);
	}
	public void drawTo(Point that){
		StdDraw.line(this.x,this.y,that.x,that.y);
	}
	public String toString(){
		return "(" + x +","+y+")";
	}
	public int compareTo(Point that){
		if (this.x == that.x && this.y == that.y) {
			return 0;
		} else if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
			return -1;
		} else {
			return 1;
		}	
	}
	public double slopeTo(Point that){
		if((that.y==this.y)&&(that.x==this.x)) {
			return Double.NEGATIVE_INFINITY;
		}
		else if(that.y==this.y) {
			return +0.0;
		}
		else if(that.x==this.x) {
			return Double.POSITIVE_INFINITY;
		}
		else {
			return (double) (that.y - this.y)/(double)(that.x - this.x);
		}
	}
	public Comparator<Point> slopeOrder(){
		SlopeOrder s = new SlopeOrder();
		return s;
	}
	private class SlopeOrder implements Comparator<Point>{
		Point p = new Point(x,y);
		public int compare(Point p1, Point p2){
			if(p.slopeTo(p1)<p.slopeTo(p2)) return -1;
			if(p.slopeTo(p1)>p.slopeTo(p2)) return 1;
			return 0;
		}
	}
	
	
	public static void main(String[] args){
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		Point p3 = new Point(2,4);
		Comparator<Point> cp = p1.slopeOrder();
		System.out.println(cp.compare(p2,p3));
		
	}
}
