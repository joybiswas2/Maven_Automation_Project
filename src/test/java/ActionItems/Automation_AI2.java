package ActionItems;

public class Automation_AI2 {
    public static void main(String[] args) {
        //declare variable
        int grade = 59;
        //if above 90 then its a 100
        if(grade >= 90 && grade <= 100){
            System.out.println("Grade is A");
        }else if(grade >= 80 && grade < 90){
            System.out.println("Grade is B");
        }else if(grade >= 70 && grade < 80){
            System.out.println("Grade is C");
        } else if (grade >= 60 && grade < 70) {
            System.out.println("Grade is a D");
        }else if (grade < 60){
            System.out.println("Grade is a F");
        }

    } //end of main function
}//end of class
