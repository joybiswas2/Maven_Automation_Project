package Day2_022623;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        //Arraylist of countries
        ArrayList<String> countries = new ArrayList<>();

        countries.add("USA");
        countries.add("India");
        //gets index 1
        System.out.println(countries.get(1));
        //prints array
        System.out.println(countries);
        //get count of list
        System.out.println(countries.size());

        countries.remove("USA");
        System.out.println(countries);
    }
}
