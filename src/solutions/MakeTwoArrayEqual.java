package solutions;

import java.util.Arrays;

/**
 * 1460 Make Two Arrays Equal by Reversing Sub-arrays
 */
public class MakeTwoArrayEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i = 0; i < target.length; i++) {
            if(target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
