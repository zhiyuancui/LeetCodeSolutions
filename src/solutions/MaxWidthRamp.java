package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int[] copy = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            copy[i] = i;
        }

        Arrays.sort(copy, Comparator.comparingInt(a -> nums[(int) a]));


        int max = 0;
        int min = nums.length;

        for(int i : copy) {
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }

        return max;
    }
}
