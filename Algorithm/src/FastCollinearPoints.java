import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
	private Point currentPoint;
	private int linenum = 0;
	private List<LineSegment> list;
	public FastCollinearPoints(Point[] points){
		if(points==null) throw new IllegalArgumentException();
		int num = points.length;
		for(int i =0; i < num; i++){
			currentPoint = points[i];
			for(int j = i+1; j < num; j++){
				if(points[j].compareTo(currentPoint) == 0){
					throw new IllegalArgumentException();
				}
			}
		}
		Point[] copy = Arrays.copyOf(points,num);
		Arrays.sort(copy,0,num);
		if(num < 4){
			return;
		}
		for(int i = 0; i < num -1; i++){
			Point initalPoint = copy[i];
			Point[] otherPoints = new Point[num-1];
			int otherPointsNum = 0;
			for(int j = 0; j < num; j++){
				if(i!=j){
				otherPoints[otherPointsNum] = copy[j];
				otherPointsNum++;
				}
			}
				Arrays.sort(otherPoints,copy[i].slopeOrder());
				Point max = null;
				Point min = null;
				int count = 0;
				for(int c = 0; c < otherPointsNum-1; c++){
					if (Double.compare(initalPoint.slopeTo(otherPoints[c]), initalPoint.slopeTo(otherPoints[c+1])) == 0) {
						count++;
					if(max==null&&min==null){
						if(initalPoint.compareTo(otherPoints[c])>0){
							max = initalPoint;
							min = otherPoints[c];
						}else{
							min = initalPoint;
							max = otherPoints[c];
						}
					}
					if(otherPoints[c+1].compareTo(min)<0){
						min = otherPoints[c+1];
					}
					if(otherPoints[c+1].compareTo(max)>0){
						max = otherPoints[c];
					}
					if (c == otherPointsNum - 2 && count >= 2 && initalPoint.compareTo(min) == 0) {
						list.add(new LineSegment(min,max));
						min.drawTo(max);
						linenum++;
						}
					}else{
						if (count >= 2 && initalPoint.compareTo(min) == 0) {
							list.add(new LineSegment(min,max));
							min.drawTo(max);
							linenum++;
						}
						count = 0;
						max = null;
						min = null;
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
}