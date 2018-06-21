

package dungeon;

/**
 *
 * @author Thumbone1
 */
public abstract class Character {
    private int xPos;
    private int yPos;
    private boolean isAlive;
    
    public Character(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        this.isAlive = true;
    }
    
    public Character() {
        this(0, 0);
    }
    
    public void move(int x, int y) {
        xPos += x;
        yPos += y;
    }
    
    public int getXPos() {
        return xPos;
    }
    
    public int getYPos() {
        return yPos;
    }
    
    public void setAlive(boolean bool) {
        isAlive = bool;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    @Override
    public String toString() {
        return xPos + " " + yPos;
    }

}
