package solutions;


/**
 * According the discussion: https://leetcode.com/discuss/82822/solution-explanation
 * @author Zhiyuan
 *
 */
public class PatchingArray {
	public int minPatches(int[] nums, int n) {
		int cnt = 0,i=0;
        for(long known_sum = 1;known_sum <= n;){
            if(i < nums.length && known_sum >= nums[i]){
                known_sum += nums[i++];
            }else{
                known_sum <<= 1;
                cnt++;
            }
        }
        return cnt;
    }
	
	public static void main(String[] args){
		PatchingArray p = new PatchingArray();
		int[] nums = {1,5,10};
		p.minPatches(nums, 20);
	}
}
