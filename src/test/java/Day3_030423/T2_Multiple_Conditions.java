package Day3_030423;

public class T2_Multiple_Conditions {
    public static void main(String[] args) {
        int a,b,c;
        a = 1;
        b = 2;
        c = 3;
        if(a+b > c){
            System.out.println("a + b is greater than c");
        }else if(a+b < c){
            System.out.println("A + b is less than c");
        }else{
            System.out.println("A + b is equal to C");
        }
    }
}
