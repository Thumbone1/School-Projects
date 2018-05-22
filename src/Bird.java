/**
 *
 * @author Thumbone1
 */

public class Bird {
    private String commonName;
    private String latinName;
    private int numObservations;
    
    public Bird(String commonName, String latinName) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.numObservations = 0;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }
    
    @Override
    public String toString() {
        return this.commonName + " (" + this.latinName + "): " 
                + getObservations() + " observations"; 
    }
    
    public void addObservation() {
        this.numObservations++;
    }
    
    public int getObservations() {
        return this.numObservations;
    }

}
