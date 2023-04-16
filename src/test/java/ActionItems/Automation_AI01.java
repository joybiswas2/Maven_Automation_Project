package ActionItems;

import java.util.ArrayList;

public class Automation_AI01 {
    public static void main(String[] args) {
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Japan");
        country.add("Korea");
        country.add("Bangladesh");

        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(81);
        countryCode.add(82);
        countryCode.add(880);

        for(int i=0; i < country.size(); i++){
            System.out.println(("My country is ") + country.get(i) + (" and my country code is ") + countryCode.get(i));
        }
    }
}
