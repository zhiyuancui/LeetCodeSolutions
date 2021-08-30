package solutions;

/**
 * 992 Subarrays with K Different Integers
 */
public class SubarrayWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        int len = nums.length;

        int[] freq = new int[len+1];

        int left = 0;
        int right = 0;

        int count = 0;
        int res = 0;

        while(right < len) {
            if(freq[nums[right]] == 0) {
                count++;
            }
            freq[nums[right]]++;
            right++;

            while(count > k) {
                freq[nums[left]]--;

                if(freq[nums[left]] == 0) {
                    count--;
                }
                left++;
            }

            res += right - left;
        }

        return res;
    }
}
