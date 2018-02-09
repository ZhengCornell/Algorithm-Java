import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
	private Set<Point2D> set;
	public PointSET(){


		this.set = new TreeSet<>();
	}
	public boolean isEmpty(){
		return this.set.isEmpty();
	}
	public int size(){
		return this.set.size();
	}
	public void insert(Point2D p){
		if(p == null){
			throw new IllegalArgumentException();
		}
		this.set.add(p);
	}
	public boolean contains(Point2D p){
		if(p == null){
			throw new IllegalArgumentException();
		}
		return this.set.contains(p);
	}
	public void draw(){
		for(Point2D p:this.set){
			StdDraw.point(p.x(),p.y());
		}
	}
	public Iterable<Point2D> range(RectHV rect){
		if(rect == null){
			throw new IllegalArgumentException();
		}
		List<Point2D> l = new ArrayList<>();
		for(Point2D p:this.set){
			if(rect.contains(p)){
				l.add(p);
			}
		}
		return l;
	}
	public Point2D nearest(Point2D p){
		if(p == null){
			throw new IllegalArgumentException();
		}
		Point2D p2 = null;
		for(Point2D temp:this.set){
			if(p2 == null || temp.distanceSquaredTo(p) < p2.distanceSquaredTo(p)){
				p2 = temp;
			}
		}
		return p2;
	}
}
