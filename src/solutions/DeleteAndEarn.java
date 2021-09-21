package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740 Delete and Earn
 */
public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int n : nums){
            count[n] += n;
        }
        int[] dp = new int[10003];
        for(int i = 10000; i >= 0; i--) {
            dp[i] = Math.max(count[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
	}

    public int deleteAndEarn2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        List<Integer> sum = new ArrayList<>();

        sum.add(nums[0]);

        int size = 1;
        for(int i = 1; i < n; i++) {
            int val = nums[i];
            if(val == nums[i-1]) {
                sum.set(size - 1, sum.get(size-1) + val);
            } else if(val == nums[i-1] + 1) {
                sum.add(val);
                size++;
            } else {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }

        ans += rob(sum);

        return ans;
    }

    public int rob(List<Integer> nums) {
        int size =  nums.size();
        if(size == 1) {
            return nums.get(0);
        }

        int first = nums.get(0);
        int second = Math.max(nums.get(0), nums.get(1));

        for(int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first+nums.get(i), second);
            first = temp;
        }

        return second;
    }
}
