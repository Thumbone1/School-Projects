import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program
        
        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        
        Grader grades = new Grader();
        System.out.println("Type exam scores,  -1 completes: ");
        while(true) {
            
            int i = Integer.parseInt(s.nextLine());
            
            if (i == -1) {
                break;
            }
            Grade grade = new Grade(i);
            grades.addGrade(grade);
           
        }
        
        grades.printDistribution();
        grades.printAccPercent();
        
    }
}
