
public class Leg {
	protected Location origin;
	protected Location destination;
	protected String daysAvailable;
	
	protected int distance = 0;
	protected double costPerKm = 0;
	
	public Leg(Location origin, Location destination, int distanceInKm, String days, double costPerKm){
		this.origin = origin;
		this.destination = destination;
		this.distance = distanceInKm;
		this.daysAvailable = days;
		this.costPerKm = costPerKm;
	}
	
	// returns leg type
	public String getLeg() {
		return "leg";
	}
	
	@Override
	public String toString() {
		return "Origin: " + origin.getName() + " | " + "Destination: " + destination.getName() + " | " 
				+ "Avaliable Days: " + daysAvailable + " | " + "Distance: " + distance + " | "
				+ "Cost Per KM: " + costPerKm;
		
	}
	
	public String oToD() {
		return "Origin: " + origin.getName() + " " + "Destination: " + destination.getName(); 
		
	}
}
