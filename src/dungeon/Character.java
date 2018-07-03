

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
    
    public void moveX(int x) {
        xPos += x;
    }
    
    public void moveY(int y) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.xPos;
        hash = 47 * hash + this.yPos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Character other = (Character) obj;
        if (this.xPos != other.xPos) {
            return false;
        }
        if (this.yPos != other.yPos) {
            return false;
        }
        return true;
    }

    // abstract methods for Player class
    public abstract void useFlashlight();
    public abstract int getBlinksLeft();

}
