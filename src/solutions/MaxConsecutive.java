package solutions;

public class MaxConsecutive {

    /**
     * 485. Max Consecutive Ones
     * @param nums
     * @return
     */
	public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] == 1 ){
                count++;
                max = Math.max(max, count);
            } else {
                count=0;
            }

        }

        return max;
    }

    /**
     * Max Consecutive Ones III
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        if(A == null || A.length == 0) {
            return 0;
        }

        int left = 0, right;

        for(right = 0; right < A.length; right++) {
            if(A[right] == 0) {
                K--;
            }

            if(K < 0) {
                if(A[left] == 0) {
                    K++;
                }
                left++;
            }
        }

        return right - left;
    }
}
