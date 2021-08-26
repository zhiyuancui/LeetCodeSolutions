package solutions;

/**
 * 1588 Sum of All Odd Length Subarrays
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/cong-on3-dao-on-de-jie-fa-by-liuyubobobo/
 */
public class SumofAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;

        for(int i = 0; i < arr.length; i++) {
            int left = i;
            int right = arr.length - i - 1;
            int left_even = left / 2 + 1;
            int right_even = right / 2 + 1;
            int left_odd = (left+1) / 2;
            int right_odd = (right+1) / 2;

            res += (left_even * right_even + left_odd * right_odd) * arr[i];
        }

        return res;
    }
}
