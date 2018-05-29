
import java.util.Scanner;

/**
 *
 * @author Thumbone1
 */
public class TextUserInterface {
    private Scanner scanner;
    private Airplanes airplanes;
    
    public TextUserInterface(Scanner scanner, Airplanes airplanes) {
        this.scanner = scanner;
        this.airplanes = airplanes;
    }
    
    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        airportPanel();
        
        System.out.println("");
        System.out.println("Flight service");
        System.out.println("--------------------");
        System.out.println("");
        
        flightService();
        
    }
    
    private void airportPanel() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String response = scanner.nextLine();
            
            if (response.equals("x")) {
                break;
            }
            
            if (response.equals("1")) {
                addAirplane();
            }
            
            if (response.equals("2")) {
                addFlight();
            }
        }
    }
    
    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String id = scanner.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());        
        airplanes.addPlane(id, new Airplane(id, capacity));
    }
    
    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = scanner.nextLine();
        System.out.print("Give departure airport code: ");
        String from = scanner.nextLine();
        System.out.print("Give destination airport code: ");
        String to = scanner.nextLine();
        airplanes.addFlight(id, from, to);
    }
    
    private void flightService() {
        while(true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            String response = scanner.nextLine();
            
            if (response.equals("x")) {
                break;
            }
            
            if (response.equals("1")) {
                airplanes.printPlanes();
            }
            
            if (response.equals("2")) {
                airplanes.printPlanesAndFlights();
            }
            
            if (response.equals("3")) {
                printPlaneInfo();
            }
            
        }
    }
    
    private void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String response = scanner.nextLine();
        airplanes.printOnePlane(response);
    }
    

}
