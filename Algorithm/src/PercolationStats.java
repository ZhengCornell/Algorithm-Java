import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private int[] count;
	private final int cishu;
	private int size;
	
	public PercolationStats(int n, int trials) {
		if(n <= 0 || trials <= 0){
			throw new IllegalArgumentException();
		} else{
		count = new int[trials];
		cishu = trials;
		size = n;
		for(int i = 0; i < trials; i++){
		Percolation p = new Percolation(n);
		while(!p.percolates()){
			int x = StdRandom.uniform(1, n+1);
			int y = StdRandom.uniform(1, n+1);
			p.open(x, y);
		}
//		System.out.println(p.numberOfOpenSites());
		count[i] = p.numberOfOpenSites();
		}
		}
		
	}
	public double mean() {
		double d = StdStats.mean(this.count)/((size)*(size)*1.0);
		return d;
	}

	public double stddev() {
		return StdStats.stddev(this.count);
	}

	public double confidenceLo() {
		double sum = 0;
		double d;
		double k = 0.0;
		double s;
		double g;
		for (int i = 0; i < cishu; i++) {
			sum = sum + count[i];
		}
		d = sum*1.0/(cishu);
		for (int j = 0; j < cishu; j++){
			k = (k+(count[j]-d)*(count[j]-d)*1.0); 
		}
		s = k / (cishu - 1);
		
		g = d - (1.96*s) / Math.sqrt(cishu);
		return g;
	}
	public double confidenceHi() {
		double sum = 0;
		double d;
		double k = 0.0;
		double s;
		double g;
		for (int i = 0; i < cishu; i++) {
			sum = sum + count[i];
		}
		d = sum*1.0/(cishu);
		for (int j = 0; j < cishu; j++) {
			k = (k+(count[j]-d)*(count[j]-d)*1.0); 
		}
		s = k / (cishu - 1);
		
		g = d + (1.96*s) / Math.sqrt(cishu);
		return g;
	}
	
	
	public static void main(String args[]){
		PercolationStats ps = new PercolationStats(5,100);
		System.out.println(ps.stddev());
		System.out.println(ps.mean());
		System.out.println(ps.confidenceLo());
		System.out.println(ps.confidenceHi());
	}
}
