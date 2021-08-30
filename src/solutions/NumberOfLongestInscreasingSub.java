package solutions;

/**
 * 673 Number of Longest Increasing Subsequence
 */
public class NumberOfLongestInscreasingSub {
	/**
	 * len[i] : the length of the Longest Increasing Subsequence which ends with nums[i]
	 * count[i] : the number of the longest Increasing Subsequence which ends with nums[i]
	 * @param nums
	 * @return
	 */
	public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] len = new int[nums.length];
        int[] count = new int[nums.length];

        int maxLength = 0;
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++) {
            len[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(len[i] == len[j] + 1){
                        count[i] += count[j];
                    } else if(len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }

            if(maxLength == len[i]) {
                maxCount += count[i];
            } else if(maxLength < len[i]) {
                maxLength = len[i];
                maxCount = count[i];
            }
        }

        return maxCount;
    }
}
