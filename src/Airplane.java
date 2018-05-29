
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thumbone1
 */
public class Airplane {
    private String id;
    private int capacity;
    private Map<String, String> flights;
    
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.flights = new HashMap<String, String>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getId() {
        return this.id;
    }
    
    public void addFlight(String from, String to) {
        this.flights.put(from, to);
    }    

    @Override
    public String toString() {
        return this.getId() + " (" + this.getCapacity() + " ppl)"; 
    }
    
    public ArrayList<String> flightList() {
        ArrayList<String> flightList = new ArrayList<String>();
        
        for (String key : this.flights.keySet()) {
            flightList.add("(" + key + "-" + this.flights.get(key) + ")");
        }
        
        return flightList;
    
}
    
    

}
