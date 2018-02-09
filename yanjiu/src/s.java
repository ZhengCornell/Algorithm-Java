
public class s {
	private Node[] ns;
	
	private static class Node{
		private Point p;
		private Node next;
		public Point getP() {
			return p;
		}
		public void setP(Point p) {
			this.p = p;
		}
	}
	
	private static class Point{
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static double zhochang(Node[] ns){
		ns = new Node[4];
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,0);
		Point p3 = new Point(1,1);
		Point p4 = new Point(0,1);
		Node n1 = new Node();
		n1.setP(p1);
		
		return 0.0;
	}

}
