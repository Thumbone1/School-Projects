

package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class Box implements Thing {
    private int maximumCapacity;
    private List<Thing> things;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (this.maximumCapacity - this.getVolume() >= thing.getVolume()) {
            things.add(thing);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : things) {
            volume += thing.getVolume();
        }
        return volume;
    }
    

}
