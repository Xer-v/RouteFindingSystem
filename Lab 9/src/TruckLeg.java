public class TruckLeg extends Leg{

	public TruckLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.58*distanceInKm);
	}
	
	// returns leg type
	public String getLeg() {
		return "Truckleg";
	}

}