import java.util.ArrayList;

public class Route {
	private ArrayList <Leg> Legs = new <Leg> ArrayList();
	
	// loops through legs arraylist to get total cost
	public double totalCost() {
		double total = 0;
		
		for(Leg l: Legs) {
			total += l.costPerKm;
		}
		
		return total;
		
	}
	
	// loops through legs arraylist to get total distance
	public int totalDistance() {
		int total = 0;
		
		for(Leg l: Legs) {
			total += l.distance;
		}
		
		return total;
		
	}
	
	// loops through legs arraylist to get total steps
	public int totalSteps() {
		int total = 0;
		
		for(Leg l: Legs) {
			total++;
		}
		
		return total;	
		
	}
	
	// adds leg to arrayList
	public void addLeg(Leg leg) {
		Legs.add(leg);
	}
	
	// returns legs arrayList
	public ArrayList getList() {
		return Legs;
	}
	
	@Override
	public String toString() {
		int steps = totalSteps();
		int distance = totalDistance();
		double cost = totalCost();
		String leggies = Legs.get(0).oToD();
		
		for(int i = 1; i < Legs.size(); i++) {
			leggies += "\n " + Legs.get(i).oToD();
		}
		
		return " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n "
				+ "Steps: " + steps + " Distance: " + distance + " Cost: " + cost
				+ "\n Route Start: \n "
				+ leggies 
				+ " \n Route End. " 
                + "\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
		
		
	}
}

