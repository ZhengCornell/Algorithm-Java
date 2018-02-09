package week1;

public class DistanceFilter implements Filter {
	private Location loc;
	private double maxD;
	public DistanceFilter(Location location, double distance){
		this.loc = location;
		this.maxD = distance;
	}
	@Override
	public boolean satisfies(QuakeEntry qe) {
		return qe.getLocation().distanceTo(loc) < maxD;
	}
	public String getName() {
		return "DistanceFilter";
	}
	
}
