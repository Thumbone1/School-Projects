
import java.util.ArrayList;

/**
 *
 * @author Thumbone1
 */
public class Grader {
    
    private ArrayList<Grade> grades;
        
    public Grader() {
        this.grades = new ArrayList<Grade>();
    }
    
    public void addGrade(Grade grade) {
        if (grade.getGrade() >= 0) {
            this.grades.add(grade);            
        }        
    }
    
    public double acceptancePercentage() {    
        return 100 *  (double)numAcceptedGrades()/ (double)numGrades();
    }
    
    public void printDistribution() {
        System.out.println("Grade distribution:");    
        for(int i = 5; i >= 0; i--) {
            System.out.print(i + ": " );
            for(Grade grade : this.grades) {
                if (grade.getGrade() == i) {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }    
   
    public void printAccPercent() {
        System.out.println("Acceptance percentage: " 
                + acceptancePercentage());        
    }    
    
    public int numGrades() {
        return this.grades.size();
    }
    
    public int numAcceptedGrades() {
        int total = 0;
        for (Grade grade : this.grades) {
            if (grade.getGrade() > 0) {
                total++;
            }
        }
        return total;
    }

}
