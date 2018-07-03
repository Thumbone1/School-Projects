

package dungeon;

/**
 *
 * @author Thumbone1
 */
public class Vampire extends Character {
    
    public Vampire(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        return "v " + super.toString();
    }

    
    /**
     * Honestly didn't realize when I started that abstract classes required 
     * abstract methods... So these Player methods are useless for the Vampire class
     * :/
     */
    @Override
    public void useFlashlight() {
    }

    @Override
    public int getBlinksLeft() {
        return 0;
    }

}
