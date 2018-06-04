




import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Thumbone1
 */
public class TextUserInterface {
    Scanner reader;
    ContactsBook contacts;

    public TextUserInterface(Scanner reader) {
        this.reader = reader;
        this.contacts = new ContactsBook();
    }

    public void start() {
        System.out.println("phone search");
        printMenu();
        while(true) {
            System.out.print("command: ");
            String response = reader.nextLine();           
            
            if (response.equals("x")) {
                break;
            }
            if (response.equals("1")) {
                addNumber();
            }
            if (response.equals("2")) {
                searchNumber();
            }
            if (response.equals("3")) {
                searchByNumber();
            }
            if (response.equals("4")) {
                addAddress();
            }
            if (response.equals("5")) {
                searchForPersonalInformation();
            }
            if (response.equals("6")) {
                deletePerson();
            }
            if (response.equals("7")) {
                filteredListing();
            }
            
        }
        
    }
    
    private void printMenu() {
        System.out.println("available operations:\n" +                
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        contacts.addNumber(name, number);
        System.out.println("");
                
    }

    private void searchNumber() {
        System.out.print("whos number: ");
        String name = reader.nextLine();
        if (contacts.getPhoneNumbers().containsKey(name)) {
            List<String> numbers = contacts.searchNumber(name);
        
            for(String number : numbers) {
                System.out.println(" " + number);            
            }
        } else {
            System.out.println("  not found");
        }
        System.out.println("");
        
    }

    private void searchByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();        
        String name = contacts.searchByNumber(number);
        
        if (name.isEmpty()) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + name);
        }
        System.out.println("");
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        
        contacts.addAddress(name, street, city);
        System.out.println("");
    }

    private void searchForPersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        
        String address = contacts.searchForAddress(name);
        List<String> numbers = contacts.searchNumber(name);
        
        if (address.equals("") && numbers.isEmpty()) {
            System.out.println("  not found");
        } else {
            if (address.equals("")) {
                System.out.println("  address unknown");
            } else {
                System.out.println("  address: " + address);
            }

            if (numbers.isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                System.out.println("  phone numbers:");
                for (String number : numbers) {
                    System.out.println("   " + number);
                }
            }
        }
        
        
        System.out.println("");
        
    }

    private void deletePerson() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        contacts.remove(name);
    }

    private void filteredListing() {
        Set<String> namesSet = new HashSet<String>();
        List<String> namesArray = new ArrayList<String>();
        
        System.out.print("keyword (if empty, all listed): ");
        String searchString = reader.nextLine();
        System.out.println("");
        
        for (String name : contacts.getNamesList()) {
            if (name.contains(searchString)) {
                namesSet.add(name);
            }
        }
        
        for (String address : contacts.getAddressesList()) {
            if (address.contains(searchString)) {
                namesSet.add(contacts.searchByAddress(address));
            }
        }
        
        if (!namesSet.isEmpty()) {
            for (String name : namesSet) {
                namesArray.add(name);
            }
            
            Collections.sort(namesArray);
            for (String name : namesArray) {
                
                System.out.println(" " + name);
                String address = contacts.searchForAddress(name);
                if (!address.equals("")) {
                    System.out.println("  address: " + address);
                } else {
                    System.out.println("  address unknown");
                }
                if (contacts.searchNumber(name).isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    List<String> numbers = contacts.searchNumber(name);
                    System.out.println("  phone numbers:");
                    for (String number : numbers) {
                        System.out.println("   " + number);
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println(" keyword not found");
            System.out.println("");
                    
        }
                
    }

}
