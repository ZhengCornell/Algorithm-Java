package princeton.day3;

import edu.princeton.cs.algs4.StdDraw;

public class Particle {
	private double rx,ry;
	private double vx,vy;
	private final double radius = 0.01;
	public Particle(){
		
	}
	
	
	public Particle(double rx, double ry, double vx, double vy) {
		super();
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
	}


	public void move(double dt){
		if((rx+vx*dt<radius)||(rx+vx*dt>1-radius)) {
			vx = -vx;
		}
		if((ry+vy*dt<radius)||(ry+vy*dt>1-radius)) {
			vy = -vy;
		}
		rx = rx + vx*dt;
		ry = ry + vy*dt;
	}
	
	
	public void draw(){
		StdDraw.filledCircle(rx,ry,radius);
	}
}
