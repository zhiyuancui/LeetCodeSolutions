package solutions;

public class MaxProduct {
	
	/**
	 * 
	 * @param words
	 * @return
	 */
	public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
        return 0;
    int len = words.length;
    int[] value = new int[len];
    for (int i = 0; i < len; i++) {
        String tmp = words[i];
        value[i] = 0;
        for (int j = 0; j < tmp.length(); j++) {
            value[i] |= 1 << (tmp.charAt(j) - 'a');
        }
    }
    int maxProduct = 0;
    for (int i = 0; i < len; i++)
        for (int j = i + 1; j < len; j++) {
        	if ((value[i] & value[j]) == 0 ){
                maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
        	}
        }
    return maxProduct;
    }
	
	/**
	 * Maximum Product Subarray
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
        
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        
        if( nums.length == 1 ){
            return nums[0];
        }
        
        int max = 0;
        int min = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min( min * nums[i], temp * nums[i]));
            res = Math.max(res, max);
        }
        
        return res;
    }
}
