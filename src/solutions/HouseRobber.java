package solutions;

import util.TreeNode;

public class HouseRobber {
	public int rob3(TreeNode root) {
		int[] res = robSub3(root);
	    return Math.max(res[0], res[1]);
    }
	
	private int[] robSub3(TreeNode root) {
	    if (root == null) {
	        return new int[2];
	    }

	    int[] left = robSub3(root.left);
	    int[] right = robSub3(root.right);

	    int[] res = new int[2];
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];

	    return res;
	}
	
	/**
	 * House Robber
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        
        if( nums.length == 1 ){
            return nums[0];
        }
        
        int[] money = new int[ nums.length ];
        
        money[0] = nums[0];
        money[1] = Math.max( money[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            money[i] = Math.max( money[ i - 1 ], money[ i - 2] + nums[i]);
        }
        
        return money[ nums.length - 1 ];
    }
	
	public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int curr, prev, prev2;
        curr = prev = prev2 = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
	
}
