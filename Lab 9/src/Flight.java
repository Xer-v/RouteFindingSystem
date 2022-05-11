
public class Flight extends Leg{

	public Flight(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.23*distanceInKm);
		// TODO Auto-generated constructor stub
	}
	
	// returns leg type
	public String getLeg() {
		return "Flight";
	}
}
