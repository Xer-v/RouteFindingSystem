import java.util.ArrayList;

public class Location {
	private String name;
	private ArrayList <Leg> connectionLegs = new <Leg> ArrayList();
	
	public Location(String n) {
		name = n;
	}
	
	// returns name of location
	public String getName() {
		return name;
	}
	
	// returns location type 
	public String getType() {
		return "place";
	}
	
	// adds connected leg to arraylist
	public void addConnection(Leg leg) {
		connectionLegs.add(leg);
	}
	
	// finds cheapest route based on destination and date, returns null when not found
	public Route cheapestRouteTo(Location loc, String day) {
		ArrayList <Route> routes = new <Route> ArrayList();
		Route cheapestRoute = null;
		
		// default return when destination is reached
		if(this == loc) {
			return null;
		}
		
		// calls route creator to get arraylist of routes
		routeCreator(routes, loc, day, 0);
		
		// calls bestRoute to find the cheapest one
		return bestRoute(routes, 0);
		
	}
	
	// finds shortest route by steps based on destination and date, returns null when not found
	public Route minStepsRouteTo(Location loc, String day) {
		ArrayList <Route> routes = new <Route> ArrayList();
		Route shortestRoute = null;
		
		// default return when destination is reached
		if(this == loc) {
			return null;
		}
		
		// calls route creator to get arraylist of routes
		routeCreator(routes, loc, day, 1);
		
		// calls bestRoute to find the shortest one in steps 
		return bestRoute(routes, 1);
		
	}
	
	// finds shortest route by Km based on destination and date, returns null when not found
	public Route shortestKmRouteTo(Location loc, String day) {
		ArrayList <Route> routes = new <Route> ArrayList();
		
		// default return when destination is reached
		if(this == loc) {
			return null;
		}
		
		// calls routeCreator to get arraylist of routes
		routeCreator(routes, loc, day, 2);
		
		// calls bestRoute to find the fastest one
		return bestRoute(routes, 2);
	}
	
	// validates, creates, and sorts routes based on which type is called
	public void routeCreator(ArrayList <Route> routes, Location loc, String day, int type) {
		// loops that goes through each branching leg 
				for(int i = 0; i < connectionLegs.size(); i++) {
					Route thisRoute = new Route();
					Leg startPath = connectionLegs.get(i);
					ArrayList <Leg> pathLegs = new <Leg> ArrayList();
					
					// checks if leg is valid, else continue loop
					if(startPath.origin.equals(this) && startPath.daysAvailable.contains(day)) {
						
						// check for which route method is called based on type 
						// 0 = cheapest, 1 = min steps, 2 = shortest by km
						if(type == 0) {
							
							// checks if path returns valid route and contains list of legs in arraylist
							if(startPath.destination.cheapestRouteTo(loc, day) != null) {
								pathLegs = startPath.destination.cheapestRouteTo(loc, day).getList();
							}
							
						} else if(type == 1) {
							
							// checks if path returns valid route and contains list of legs in arraylist
							if(startPath.destination.minStepsRouteTo(loc, day) != null) {
								pathLegs = startPath.destination.minStepsRouteTo(loc, day).getList();
							}
							
						} else if(type == 2) {
							
							// checks if path returns valid route and contains list of legs in arraylist
							if(startPath.destination.shortestKmRouteTo(loc, day) != null) {
								pathLegs = startPath.destination.shortestKmRouteTo(loc, day).getList();
							}
							
						}
						
					} else {
						continue;
					}
					
					// adds this branches legs to route
					thisRoute.addLeg(startPath);
					for(Leg l: pathLegs) {
						thisRoute.addLeg(l);
					}
					
					// checks if route is valid and adds route to arraylist
					for(int j = 0; j < thisRoute.getList().size(); j++) {
						Leg thisLeg = (Leg) thisRoute.getList().get(j);
						if(thisLeg.destination.equals(loc)) {
							routes.add(thisRoute);
						}
					}
				}
		
	}
	
	// compares and sorts all the routes to find the best fit route 
	public Route bestRoute(ArrayList <Route> routes, int type) {
		double bestThing = 0;
		Route bestRoute = null;
		
		// goes through each route possible to find the best one
		for(int i = 0; i < routes.size(); i++) {
			
			// determines which code to use based on type 
			// 0 = cheapest, 1 = min steps, 2 = shortest by km
			if(type == 0) {
				if(bestThing > routes.get(i).totalCost() && i != 0) {
					bestThing = routes.get(i).totalCost();
					bestRoute = routes.get(i);
				} else if(i == 0){
					bestThing = routes.get(i).totalCost();
					bestRoute = routes.get(i);
				}
					
				// compares route to all other routes 
				for(int j = i+1; j < routes.size(); j++) {
					if(bestThing >  routes.get(j).totalCost()) {
						bestThing = routes.get(j).totalCost();
						bestRoute = routes.get(j);
					}
				}
			} else if (type == 1) {
				if(bestThing > routes.get(i).totalSteps() && i != 0) {
					bestThing = routes.get(i).totalSteps();
					bestRoute = routes.get(i);
				} else if(i == 0){
					bestThing = routes.get(i).totalSteps();
					bestRoute = routes.get(i);
				}
					
				// compares route to all other routes 
				for(int j = i+1; j < routes.size(); j++) {
					if(bestThing >  routes.get(j).totalSteps()) {
						bestThing = routes.get(j).totalSteps();
						bestRoute = routes.get(j);
					}
				}
			} else if (type == 2) {
				if(bestThing > routes.get(i).totalDistance() && i != 0) {
					bestThing = routes.get(i).totalDistance();
					bestRoute = routes.get(i);
				} else if(i == 0){
					bestThing = routes.get(i).totalDistance();
					bestRoute = routes.get(i);
				}
					
				// compares route to all other routes 
				for(int j = i+1; j < routes.size(); j++) {
					if(bestThing >  routes.get(j).totalDistance()) {
						bestThing = routes.get(j).totalDistance();
						bestRoute = routes.get(j);
					}
				}
			}
		}
		
		return bestRoute;
		
	}
	
	
}