
import java.util.ArrayList;

/**
 *
 * @author Thumbone1
 */
public class BirdDatabase {
    private ArrayList<Bird> birds;
    
    public BirdDatabase() {
        this.birds = new ArrayList<Bird>();
    }
    
    public void addBird(Bird bird) {
        this.birds.add(bird);
    }
    
    public void printStatistics() {
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }
    
    public Bird getBird(String commonName) {
        for (Bird bird: birds) {
            if (bird.getCommonName().equals(commonName)) {
                return bird;
            }
        }
        return null;
    }
    
    public boolean containsBird(String name) {
        for (Bird bird : this.birds) {
            if (bird.getCommonName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
