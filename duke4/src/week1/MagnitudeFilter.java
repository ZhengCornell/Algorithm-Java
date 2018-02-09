package week1;

public class MagnitudeFilter implements Filter {
	private double minM;
	private double maxM;
	public MagnitudeFilter(double min, double max){
		this.minM = min;
		this.maxM = max;
	}
	@Override
	public boolean satisfies(QuakeEntry qe) {
		return qe.getMagnitude() >= minM && qe.getMagnitude() <= maxM;
	}
	public String getName() {
		return "MagnitudeFilter";
	}
	
}
