package Day2_022623;

public class T1_LinearArray {
    public static void main(String[] args) {
        //create a linear array
        String[] cities = new String[]{"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        System.out.println("Cities count " + cities.length);

        System.out.println("City length is " + cities[4].length());

        //create a list of zipcode
        int[] zipcode = new int[]{11218, 22222, 33333, 55555};
        System.out.println(zipcode[2]);

    }//end of main function

}//end of class
