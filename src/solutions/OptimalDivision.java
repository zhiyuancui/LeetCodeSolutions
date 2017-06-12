package solutions;

public class OptimalDivision {

	/**
	 * 要想商最大，被除数越大越好，除数越小越好。所以不论怎么加括号。被除数是第一个数字的时候被除数最大，否则都会被除小。
	 * 除数那些数字，不管你怎么加括号，都是等效的。
	 * @param nums
	 * @return
	 */
	public String optimalDivision(int[] nums) {
        String ans = "";
        if(nums.length == 0 ) return ans;
        ans = nums[0] +"";
        if(nums.length == 1) return ans;
        if(nums.length == 2) return ans + "/" + nums[1];
        ans += "/(" + nums[1];
        for(int i = 2; i < nums.length;i++)
            ans += "/" + nums[i];
        ans += ")";
        return ans;
    }
	
}
