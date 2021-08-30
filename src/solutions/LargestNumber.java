package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179 Largest Number
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }

        String[] copy = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(copy, (a,b) -> {
            String s1 = a + b;
            String s2 = b + a;

            return s2.compareTo(s1);
        });


        if(copy[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < copy.length; i++) {
            sb.append(copy[i]);
        }

        return sb.toString();
    }
}
