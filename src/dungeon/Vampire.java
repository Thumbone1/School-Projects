

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

    @Override
    public void useFlashlight() {
        return;
    }

    @Override
    public int getBlinksLeft() {
        return 0;
    }

}
