public class BigOs {

    public static void main(String[] args) {
        int [] values = {1, 2, 5, 3};
        reduce(values);

        int [] values2 = {1,7,2,4,6,8};
        maxDifference(values2);
    }

    /*
    * The first for loop finds the minimum value of the array.
    * The second for loop reduces each value in the array by the minimum value.
    * */
    public static void reduce (int[] vals) {
        int minIndex =0;
        for (int i=0; i < vals.length; i++) {
            if (vals[i] < vals[minIndex] ) {
                minIndex = i;
            }
        }
        int minVal = vals[minIndex];
        for (int i=0; i < vals.length; i++) {
            vals[i] = vals[i] - minVal;
        }

        for(int i : vals){
            System.out.println(i);
        }
    }

    /*
    * The nested for loops look for the maximum difference between any two array elements.
    * This biggest difference will be between 1 and 8.
    * */

    public static int maxDifference (int[] vals) {
        int max = 0;
        for (int i=0; i < vals.length; i++) {
            for (int j=0; j < vals.length; j++) {
                if (vals[i]-vals[j] > max) {
                    max = vals[i]-vals[j];
                }
            }
        }
        System.out.println("Max : " + max);
        return max;
    }

}
