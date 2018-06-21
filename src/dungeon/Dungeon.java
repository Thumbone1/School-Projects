

package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Thumbone1
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private boolean vampiresMove;
    private List<Character> vampireList;
    private Character player;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampiresMove = vampiresMove;
        player = new Player(moves);
        
        initializeVampires();
    }
    
    // TODO - need to add vampires and the player to board (2d Array?)
    private void drawBoard() {
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(".");
            }
            System.out.println("");
        }
        
        
    }
    
    // note - this could possibly create 2 vampires in the same location! we'll see how the test goes
    private void initializeVampires() {
        
        for (int i = 0; i < vampires; i++) {
            vampireList.add(new Vampire(new Random().nextInt(length + 1), 
                                        new Random().nextInt(height + 1)));
        }
        
    }
    
    private boolean sameLocation(Character v1, Character v2) {          
        
        return v1.getXPos() == v2.getXPos() && v1.getYPos() == v2.getYPos();
        
    }

}
