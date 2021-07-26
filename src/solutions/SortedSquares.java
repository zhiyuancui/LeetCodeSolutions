package solutions;

/**
 * 977 square of a sorted Array
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];

        int positive = 0;

        while(positive < nums.length && nums[positive] < 0) {
            positive++;
        }

        int neg = positive - 1;

        int index = 0;
        while(neg >= 0 || positive < nums.length) {
            int val1 = positive < nums.length ? nums[positive] *  nums[positive] : Integer.MAX_VALUE;
            int val2 = neg >= 0 ? nums[neg] * nums[neg] : Integer.MAX_VALUE;

            if(val2 < val1) {
                result[index] = val2;
                neg--;
            } else {
                result[index] = val1;
                positive++;
            }

            index++;
        }

        return result;
    }

}
