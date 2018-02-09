package main;

public class Point {
	double x,y,z;
	
	public Point(double _x,double _y,double _z){
		x = _x;
		y = _y;
		z = _z;
		
	}

	public double distance(Point a){
		 return Math.sqrt((x-a.x)*(x-a.x)+(y-a.y)*(y-a.y)+(z-a.z)*(z-a.z));
	}
	public static void main(String args[]){
		double t;
		Point p = new Point(5,3,7);//实参给行参再传给xyz//
		Point p2 = new Point(6,6,6);
		System.out.println(p.x);
		t = p2.distance(p);
		System.out.println(t);
		
	}
}
