

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
        
        if (vampireList.isEmpty()) {
            return;
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                boolean occupied = false;
                
                for (Character vampire : vampireList) {
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
        vampireList = new ArrayList<Character>();
        Character playerCheck = new Vampire(0,0);
        
        Set<Character> initialVampSet = new HashSet<Character>();
        
        /*
        This should ensure that there will be the correct number of vampires
        and that no vampire is loaded at the character position during
        game initialization
        */
        
        while (initialVampSet.size() < vampires) {
            
            for (int i = 0; i < vampires; i++) {
                initialVampSet.add(new Vampire(new Random().nextInt(length), 
                                               new Random().nextInt(height)));
            }
            
            if (initialVampSet.size() > vampires || initialVampSet.contains(playerCheck)) {
                initialVampSet.removeAll(initialVampSet);
            }
        }
        
        vampireList.addAll(initialVampSet);
    }
    
    private void printVampires() {
        for (Character vampire : vampireList) {
            System.out.println(vampire);
        }
    }
    
    private void moveVampires() {
        
        for (Character vampire : vampireList) {
            
            int xMove = new Random().nextInt(3) - 1;
            int yMove = new Random().nextInt(3) - 1;
            
            System.out.println("Trying to move " + vampire + " x: " + xMove + " y: " + yMove);
            
            if (vampire.getXPos() + xMove < length && 
                vampire.getYPos() + yMove < height &&
                vampire.getXPos() + xMove > 0 &&
                vampire.getYPos() + yMove > 0 &&
                !isVampireCollision(vampire, xMove, yMove)) { 
                
                vampire.moveX(xMove);
                vampire.moveY(yMove);
                
                System.out.print("moving : " + xMove + " " + yMove);
                System.out.println("\tVampires new pos " + vampire.getXPos() + 
                        " " + vampire.getYPos());
            }
        }
    }
    
    private boolean isVampireCollision(Character vampire, int xMove, int yMove) {
        /**
         * 1. create a new list with vampire removed
         * 2. create vampire v2 with new vampire position
         * 3. check if vampire v2 is the same as another in the list
         */
        
        List<Character> vampCheckList = new ArrayList<Character>();
        vampCheckList.addAll(vampireList);
        
        // mimics vampire new location to check the list for collisions
        Character vampireWithNewLocation = new Vampire(vampire.getXPos() + xMove, 
                                                       vampire.getYPos() + yMove);
        
        // necessary in case xMove and yMove are both 0
        vampCheckList.remove(vampire);
        
        return vampCheckList.contains(vampireWithNewLocation);
    }
    
    // moves player, reduces number of flashes, and checks if vampire is killed
    private void movePlayer(int xMove, int yMove) {
        
        if (player.getXPos() + xMove < length && 
            player.getYPos() + yMove < height &&
            player.getXPos() + xMove > 0 &&
            player.getYPos() + yMove > 0) {
            
            player.moveX(xMove);
            player.moveY(yMove);
            
            checkIfKill();
            player.useFlashlight();
        }
    }
    
    // Checks for killed vamps (collision with player) and *removes them from list*
    private void checkIfKill() {
        List<Character> killedVampires = new ArrayList<Character>();
        
        for (Character vampire : vampireList) {
            if (vampire.equals(player)) {
                killedVampires.add(vampire);
            }
        }
        
        vampireList.removeAll(killedVampires);
        
    }
    
    
}
