package atraining;

import java.util.ArrayList;
import java.util.List;

public class A1dian2dian1 {
	public static void main(String args[]){
	int N = 20;
	Point[] p = new Point[N];
	for(int i = 0; i < N; i++){
		p[i] = new Point(Math.random(),Math.random());
	}
	List<Double> l = new ArrayList<Double>();
	for(int i = 0; i < N - 1; i++){
		for(int j = i + 1; j < N; j++){
			double d = dis(p[i],p[j]);
			l.add(d);
		}
	}
	for(Double temp:l){
		System.out.println(temp);
	}
	
	}

	public static double dis(Point p1, Point p2){
		double dis;
		dis =Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));	
		return dis;
	}









}


class Point{
	double x;
	double y;
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point(){
		
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
}