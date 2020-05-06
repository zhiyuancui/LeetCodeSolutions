package solutions;

public class NiceSubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int result = 0, count = 0;

        for(right=0; right < nums.length; right++) {
            if(nums[right] % 2 ==1){
                k--;
                count = 0;
            }

            while(k==0) {
                count++;
                if(nums[left] % 2 ==1) {
                    k++;
                }
                left++;
            }
            result += count;
        }

        return result;
    }
}
