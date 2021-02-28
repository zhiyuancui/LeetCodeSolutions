package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }

        String[] copy = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = nums[i] + "";
        }

        Arrays.sort(copy, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for(String s: copy) {
            sb.append(s);
        }

        int index = 0;
        while(index < sb.length() - 1 && sb.charAt(index) == '0') {
            index++;
        }

        return sb.substring(index).toString();
    }
}
