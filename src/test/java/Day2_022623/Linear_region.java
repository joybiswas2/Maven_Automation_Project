package Day2_022623;

public class Linear_region {
    public static void main(String[] args) {

        String[] region = new String[]{"Northeast", "South", "Midwest", "West"};
        int[] regionalCode = new int[]{212, 239, 217, 209};

        int i = 0;
        while (i < region.length) {
            System.out.println("My region is " + region[i] + " and my area code is " + regionalCode[i]);
            i++;
        }
    }
}

//hi
