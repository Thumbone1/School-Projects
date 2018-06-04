



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Thumbone1
 */
public class ContactsBook {
    private Map<String, ArrayList<String>> phoneNumbers;
    private Map<String, String> addresses;
    private Set<String> contactSet;
    
    public ContactsBook() {
        this.phoneNumbers = new HashMap<String, ArrayList<String>>();
        this.addresses = new HashMap<String, String>();
        this.contactSet = new HashSet<String>();
    }
    
    public void addNumber(String name, String number) {
        if (!phoneNumbers.containsKey(name)) {
            phoneNumbers.put(name, new ArrayList<String>());
            contactSet.add(name);
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
        return "";
    }
    
    /**
     * 
     * @param name = creates contacts key in HashMap<String, String>
     * @param street Combined with city in the form 'street city'
     * @param city 
     */
    public void addAddress(String name, String street, String city) {
        String address = street + " " + city;            
        addresses.put(name, address);
        contactSet.add(name);
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
        
        return "";
    }
    
    public void remove(String name) {
        addresses.remove(name);
        phoneNumbers.remove(name);
    }
    
    public List<String> getNamesList() {
        List<String> names = new ArrayList<String>();
        
        for (String name : contactSet) {
            names.add(name);
        }
        return names;
    }
    
    /**
     * 
     * @return list of addresses 
     */
    public List<String> getAddressesList() {
        List<String> addressList = new ArrayList<String>();
        
        for (String name : addresses.keySet()) {
            addressList.add(addresses.get(name));
        }
        
        return addressList;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public Map<String, ArrayList<String>> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String searchByAddress(String address) {
        for (String name : addresses.keySet()) {
            if (addresses.get(name).equals(address)) {
                return name;
            }
        }
        return "";
    }
    

}
