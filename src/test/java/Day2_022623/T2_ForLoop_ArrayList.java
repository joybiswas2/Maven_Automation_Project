package Day2_022623;

import java.util.ArrayList;

public class T2_ForLoop_ArrayList {
    public static void main(String[] args) {
        //Arraylist of countries
        ArrayList<String> countries = new ArrayList<>();

        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        for (int i = 0; i < countries.size(); i++) {
            System.out.println("Country is: " + countries.get(i));
        }


        int i = 0;
        while(i < countries.size()){
            System.out.println("Country is: " + countries.get(i));
            i++;
        }

    }
}