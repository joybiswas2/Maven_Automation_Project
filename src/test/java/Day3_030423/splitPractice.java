package Day3_030423;

import java.sql.SQLOutput;

public class splitPractice {
    public static void main(String[] args) {
        String message = "My name is Joy";
        String[] newMessage = message.split(" ");
        System.out.println(newMessage[3]);
    }
}
