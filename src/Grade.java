/**
 *
 * @author Thumbone1
 */
public class Grade {
    private int score;
    private int grade;
    
    public Grade(int score) {
        this.score = score;
        if (score < 0 || score > 60) {
            this.grade = -1;
        }
        
        if (score >= 0 && score <= 29) {
            this.grade = 0;
        }
        
        if (score > 29 && score <= 34) {
            this.grade = 1;
        }
        
        if (score > 34 && score <= 39) {
            this.grade = 2;
        }
        
        if (score > 39 && score <= 44) {
            this.grade = 3;
        }
        
        if (score > 44 && score <= 49) {
            this.grade = 4;
        }
        
        if (score > 49 && score <= 60) {
            this.grade = 5;
        }
        
    }
    
    public boolean acceptedGrade() {
        return this.grade > 0;
    }

    public int getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }
    
}
