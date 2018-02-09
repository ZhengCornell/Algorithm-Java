import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints {
	private Point currentPoint;
	private int linenum = 0;
	private List<LineSegment> list;
	public BruteCollinearPoints(Point[] points){
		if(points==null) throw new IllegalArgumentException();
		for(int i = 0; i < points.length; i++){
			currentPoint = points[i];
			for(int j = i+1; j < points.length; j++){
				if(points[j].compareTo(currentPoint) == 0){
					throw new IllegalArgumentException();
				}
			}
		}
		Point[] copy = Arrays.copyOf(points,points.length);
		Arrays.sort(copy,0,points.length);
		int num = copy.length;
		list = new ArrayList<LineSegment>();
		for(int i = 0 ; i < num; i++){
			for(int j = i+1; j < num; j++){
				for(int k = j+1; k < num; k++){
					for(int l = k+1; l < num; l++){
						double slope1 = copy[i].slopeTo(copy[j]);
						double slope2 = copy[j].slopeTo(copy[k]);
						double slope3 = copy[k].slopeTo(copy[l]);
						if(Double.compare(slope1,slope2)==0&&Double.compare(slope2,slope3)==0){
							copy[i].drawTo(copy[l]);
							LineSegment ls1 = new LineSegment(copy[i],copy[j]);
							LineSegment ls2 = new LineSegment(copy[l],copy[k]);
							String str = ls1.toString() +" -> "+ ls2.toString();
							list.add(new LineSegment(copy[i],copy[j]));
							linenum++;
						}
						
					}
				}
			}
		}
		
	}
	public int numberOfSegments(){
		return linenum;
	}
	public LineSegment[] segments(){
		LineSegment[] lines = new LineSegment[linenum];
		for(int i = 0; i < linenum; i++){
			lines[i] = list.get(i);
		}
	
		return lines;
	}
	public static void main(String[] args){
		Point[] ps = new Point[7];
		ps[0] = new Point(0,0);
		ps[1] = new Point(1,0);
		ps[2] = new Point(2,0);
		ps[3] = new Point(3,0);
		ps[4] = new Point(1,1);
		ps[5] = new Point(2,2);
		ps[6] = new Point(3,3);
		BruteCollinearPoints bcp = new BruteCollinearPoints(ps);
		LineSegment[] ls = bcp.segments();
		System.out.println(ls[0]);
		System.out.println(ls[1]);
		
	}
	
	

}
