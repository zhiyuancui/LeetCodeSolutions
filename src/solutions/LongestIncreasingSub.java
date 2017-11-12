package solutions;

public class LongestIncreasingSub {
	public int findNumberOfLIS(int[] nums) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        int maxCount =0;
        int maxLen = 0;
        
        for(int i = 0; i < nums.length; i++ ) {
            len[i] = 1;
            count[i] = 1;
            for( int j = 0; j < i; j++ ) {
                if( nums[j] < nums[i] ) {
                    if( len[i] == len[j] + 1 ){
                        count[i] += count[j];
                    } else if( len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            
            if( maxLen == len[i] ) {
                maxCount += count[i];
            } else if( maxLen < len[i] ) {
                maxCount = count[i];
                maxLen = len[i];
            }
        }
        
        return maxCount;
    }
}
