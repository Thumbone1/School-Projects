
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        /*
        String input =  "1\n" + "HA-LOL\n" + "42\n" + 
                        "1\n" + "G-OWAC\n" + "101\n" +
                        "2\n" + "HA-LOL\n" + "HEL\n" + "BAL\n" + 
                        "2\n" + "G-OWAC\n" + "JFK\n" + "BAL\n" +
                        "2\n" + "HA-LOL\n" + "BAL\n" + "HEL\n" + "x\n" + 
                        // for flight service:
                        "1\n" + 
                        "2\n" +
                        "3\n" + "G-OWAC\n" + "x\n";
        */
        Scanner scanner = new Scanner(System.in);
        Airplanes airplanes = new Airplanes();
        
        TextUserInterface ui = new TextUserInterface(scanner, airplanes);
        ui.start();
        
        
    }
}
