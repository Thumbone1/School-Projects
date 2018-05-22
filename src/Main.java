
import java.util.Scanner;

public class Main {  

    public static void main(String[] args) {
    // implement your program here
    // do not put all to one method/class but rather design a proper structure to your program
        
    // Your program should use only one Scanner object, i.e., it is allowed to call 
    // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
    
    Scanner sc = new Scanner(System.in);
    BirdDatabase birds = new BirdDatabase();
    
    while(true) {
        System.out.println("? ");
        String response = sc.nextLine();
        
        if (response.equals("Quit")) {
            break;
        }
        if (response.equals("Add")) {
            System.out.println("Name: ");
            String n = sc.nextLine();
            System.out.println("LatinName: ");
            String ln = sc.nextLine();
            Bird newBird = new Bird(n, ln);
            birds.addBird(newBird);
        }
        
        if (response.equals("Observation")) {
            System.out.println("What was observed:? ");
            String n = sc.nextLine();
            if (birds.containsBird(n)) {
                birds.getBird(n).addObservation();
            } else {
                System.out.println("Is not a bird!");
            }
        }
        
        if (response.equals("Statistics")) {
            birds.printStatistics();
        }
        
        if (response.equals("Show")) {
            System.out.println("What?");
            String n = sc.nextLine();
            if (birds.containsBird(n)) {
                System.out.println(birds.getBird(n).toString());
            } else {
                System.out.println("");
            }
            
        }
    }
            
    }
    
    

}
