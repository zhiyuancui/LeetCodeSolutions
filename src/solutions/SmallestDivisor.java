package solutions;

public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int num : nums) {
            right = Math.max(right, num);
        }

        int ans = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            int total = 0;
            for(int num : nums) {
                total += (num - 1) / mid + 1;
            }

            if(total <= threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

}
