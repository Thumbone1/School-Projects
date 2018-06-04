

package contacts.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thumbone1
 */
public class ContactsBook {
    private Map<String, ArrayList<String>> phoneNumbers;
    private Map<String, String> addresses;
    
    public ContactsBook() {
        this.phoneNumbers = new HashMap<String, ArrayList<String>>();
        this.addresses = new HashMap<String, String>();
    }
    
    public void addNumber(String name, String number) {
        if (!phoneNumbers.containsKey(name)) {
            phoneNumbers.put(name, new ArrayList<String>());
            
        }
        phoneNumbers.get(name).add(number);
        
    }
    
    /**
     * 
     * @param key = name of person
     * @return List<String> with list of phone numbers or an empty list 
     *         if person not found
     */
    public List<String> searchNumber(String key) {
        if (!phoneNumbers.containsKey(key)) {
            return new ArrayList<String>();
        }
        return phoneNumbers.get(key);
    }
    
    /**
     * 
     * @param phoneNumber = phone number belonging to person you are searching for
     * @return persons name or null if number does not exist
     */
    public String searchByNumber(String phoneNumber) {
        for (String name : phoneNumbers.keySet()) {
            if (phoneNumbers.get(name).contains(phoneNumber)) {
                return name;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param name = creates contacts key in HashMap<String, String>
     * @param street Combined with city in the form 'street city'
     * @param city 
     */
    public void addAddress(String name, String street, String city) {
        String address = street + " " + city;            
        addresses.put(city, address);
    }
    
    /**
     * 
     * @param name = contacts name
     * @return address String if exists or null if it doesn't exist
     */
    public String searchForAddress(String name) {
        if (addresses.containsKey(name)) {
            return addresses.get(name);
        }
        
        return null;
    }
    
    

}
