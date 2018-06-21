

package dungeon;

/**
 *
 * @author Thumbone1
 */
public class Player extends Character {
    private int blinksLeft;
    
    public Player(int blinks) {
        super();
        this.blinksLeft = blinks;
    }

    public int getBlinksLeft() {
        return blinksLeft;
    }

    public void setBlinksLeft(int blinksLeft) {
        this.blinksLeft = blinksLeft;
    }
    
    
    
    @Override
    public String toString() {
        return "@ " + super.toString();
    } 

}
