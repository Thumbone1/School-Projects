package dungeon.util;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Thumbone1
 */
public class TextReader {
    private Scanner sc = new Scanner(System.in, "UTF-8");
    
    public String readString() {
        try {
            return sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Input is not a word/letter! \n" + e);
            return "";
        }
        
    }
    
    public int readInteger() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid number! \n" + e);
            return -1;
        }
        
    }
    
    public void close() {
        sc.close();
    }
}
