import java.util.ArrayList;

public class SystemManager {
	ArrayList <Location> locations = new <Location> ArrayList();
	ArrayList <Leg> legs = new <Leg> ArrayList();
	
	// adds locations to arraylist
	public void addLocation(Location stop){
		locations.add(stop);
	}
	
	// adds legs to arraylist
	public void addLeg(Leg distance) {
		
		// checks if origins and destination of leg is valid
		if(distance.getLeg().equals("BikeLeg")) {
			if(distance.origin.getType().equals("Airport") || !distance.destination.getType().equals("BikeDelivery")) {
				return;
			}
		} else if(distance.getLeg().equals("TruckLeg")) {
			if(!distance.origin.getType().equals("TruckStop") || distance.destination.getType().equals("BikeDelivery")) {
				return;
			}
		} else if(distance.getLeg().equals("BikeLeg")) {
			if(distance.destination.getType().equals("Airport") || distance.destination.getType().equals("TruckStop")) {
				return;
			}
		}
		
		// checks if available dates are valid and adds leg to origin and destination's arraylists
		if(distance.distance > 0) {
			if(distance.daysAvailable.contains("M") || distance.daysAvailable.contains("T") || distance.daysAvailable.contains("W") || distance.daysAvailable.contains("R") ||
					distance.daysAvailable.contains("F") || distance.daysAvailable.contains("S") || distance.daysAvailable.contains("U")){
				legs.add(distance);
				distance.origin.addConnection(distance);
				distance.destination.addConnection(distance);
			}
		}
	}
	
	// returns the location based on the name entered
	public Location findLocation(String name) {
		for(Location l: locations) {
			if(l.getName() == name) {
				return l;
			}
		}
		return null;
	}
	
	// finds cheapest route
	public Route findCheapestRoute(Location origin, Location destination, String day) {
		return origin.cheapestRouteTo(destination, day);
	}
	
	// finds the route with the least steps needed
	public Route findMinStepsRoute(Location origin, Location destination, String day) {
		return locations.get(locations.indexOf(origin)).minStepsRouteTo(destination, day);
		
	}
	
	// find the shortest route 
	public Route findShortestKmRoute(Location origin, Location destination, String day) {
		return locations.get(locations.indexOf(origin)).shortestKmRouteTo(destination, day);
		
	}

	// prints all locations and legs in system
	public void printSystemDetails() {
		System.out.println("Locations in system");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i = 0; i < locations.size(); i++) {
			String name = locations.get(i).getName();
			System.out.println(name);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		System.out.println("Legs in system");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i = 0; i < legs.size(); i++) {
			String leg = legs.get(i).toString();
			System.out.println(leg);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}
}
