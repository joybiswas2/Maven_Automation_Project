package Day3_030423;

public class T4_Split {
    public static void main(String[] args) {
        String message = "My name is John";
        //print out only john from above string
        String[] arrayMessage = message.split(" ");
        System.out.println("Result: " + arrayMessage[3]);

    }
}