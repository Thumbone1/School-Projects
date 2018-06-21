

package dungeon;

/**
 *
 * @author Thumbone1
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getMoves() {
        return moves;
    }
    
    
    

}
