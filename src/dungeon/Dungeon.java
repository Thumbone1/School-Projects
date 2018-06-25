

package dungeon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Thumbone1
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private boolean vampiresMove;
    private Set<Character> vampireSet;
    private Character player;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampiresMove = vampiresMove;
        player = new Player(moves);
        
        initializeVampires();
    }
    
    public void run() {
        System.out.println(player);
        printVampires();
        drawBoard();
        moveVampires();
        System.out.println("");
        System.out.println(player);
        printVampires();
        drawBoard();
    }
    
    private void drawBoard() {
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                boolean occupied = false;
                
                for (Character vampire : vampireSet) {
                    if (vampire.getXPos() == x && vampire.getYPos() == y) {
                        System.out.print("v");
                        occupied = true;
                    } 
                    
                }
                
                if (player.getXPos() == x && player.getYPos() == y) {
                    System.out.print("@");
                    occupied = true;
                }
                
                if (!occupied) {
                    System.out.print(".");
                }
                
            }
            System.out.println("");
        }
        
        
    }
    
     
    private void initializeVampires() {
        vampireSet = new HashSet<Character>();
        Character checkVampire = new Vampire(0,0);
        
        while (vampireSet.size() < vampires) {
            for (int i = 0; i < vampires; i++) {
                vampireSet.add(new Vampire(new Random().nextInt(length), 
                                            new Random().nextInt(height)));
            
                
            }
            
            /*
            This ensures that there will be the correct number of vampires
            and that no vampire is loaded at the character position during
            game initialization
            */
            if (vampireSet.size() > vampires || vampireSet.contains(checkVampire)) {
                vampireSet.removeAll(vampireSet);
            }
        }
    }
    
    private void printVampires() {
        for (Character vampire : vampireSet) {
            System.out.println(vampire);
        }
    }
    
    // need to move negative amounts as wwell
    private void moveVampires() {
        
        List<Character> newVampLocations = new ArrayList<Character>();
        
        for (Character vampire : vampireSet) {
            
            int xMove = new Random().nextInt(3) - 1;
            int yMove = new Random().nextInt(3) - 1;
            System.out.println("moving : " + xMove + " " + yMove);
            
            // needed to ensure no vampire collisions
            newVampLocations.add(vampire);
            
            /*
            TODO - this needs to check for vampire collisions as well:
            probably need a boolean helper method for this move
            */
            if (vampire.getXPos() + xMove < length && 
                vampire.getYPos() + yMove < height &&
                vampire.getXPos() + xMove > 0 &&
                vampire.getYPos() + yMove > 0 &&
                newVampLocations.contains(vampire)) {
                
                vampire.moveX(xMove);
                vampire.moveY(yMove);
                System.out.println("Vampires new pos " + vampire.getXPos() + " " + vampire.getYPos());
            }
        }
    }
    
    private void checkIfKill() {
        Set<Character> killedVampires = new HashSet<Character>();
        
        for (Character vampire : vampireSet) {
            if (vampire.equals(player)) {
                killedVampires.add(vampire);
            }
        }
        
        vampireSet.removeAll(killedVampires);
        
    }
}
