
public class BikeLeg extends Leg{

	public BikeLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 1.0*distanceInKm);
		// TODO Auto-generated constructor stub
	}
	
	// returns leg type
	public String getLeg() {
		return "Bikeleg";
	}

}
