package solutions;

import java.util.Arrays;

/**
 * 556 Next Greater Element III
 */
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        char[] number = Integer.toString(n).toCharArray();

        int i, j;

        for(i = number.length -1; i > 0; i--) {
            if(number[i-1] < number[i]) {
                break;
            }
        }

        if(i == 0) {
            return -1;
        }

        for(j = number.length -1; j > i; j--) {
            if(number[j] > number[i-1]) {
                break;
            }
        }

        swap(number, i-1, j);

        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));

        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
