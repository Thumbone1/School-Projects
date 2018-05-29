import java.util.*;

/**
 *
 * @author Thumbone1
 */
public class Airplanes {
    private Map<String, Airplane> airplanes;
    
    public Airplanes() {
        this.airplanes = new HashMap<String, Airplane>();
    }
    
    public void addPlane(String id, Airplane airplane) {  
        this.airplanes.put(id, airplane);
    }
    
    public void printPlanes() {
        for(String key : this.airplanes.keySet()) {
            System.out.println(this.airplanes.get(key));
        }
    }
    
    public void printPlanesAndFlights() {
        for (String key : this.airplanes.keySet()) {
            ArrayList<String> flights = this.airplanes.get(key).flightList();
            for (String flight : flights) {
                System.out.println(this.airplanes.get(key) + " " + flight);
            }            
        }
    }
    
    public void printOnePlane(String key) {
        System.out.println(this.airplanes.get(key));
    }
    
    public void addFlight(String key, String from, String to) {
        Airplane airplane = this.airplanes.get(key);
        airplane.addFlight(from, to);
    }

}
