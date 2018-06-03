

package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author Thumbone1
 */
public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(boxesVolume));
        
        int i = 0;
        int j = 0;
        while(i < things.size()) {            
            
            if (!boxes.get(j).addThing(things.get(i))) {
                boxes.add(new Box(boxesVolume));
                j++;
                boxes.get(j).addThing(things.get(i));
            } 
            i++;
        }
        
        
        return boxes;
    }
}
