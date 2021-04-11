package solutions;

public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || k <= 0) {
            return new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] ans = new int[k];

        for(int i = Math.max(0, k-len2); i <= k && i <= len1; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k -i), k);
            if(greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    private boolean greater(int[] nums1, int p1, int[] nums2, int p2) {
        while(p1 < nums1.length && p2 < nums2.length && nums1[p1] == nums2[p2]) {
            p1++;
            p2++;
        }
        return p2 == nums2.length ||(p1 < nums1.length && nums1[p1] > nums2[p2]);
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        while(idx < k) {
            ans[idx] = greater(nums1, p1, nums2, p2) ? nums1[p1++] : nums2[p2++];
            idx++;
        }
        return ans;
    }

    private int[] maxArray(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[k];
        int idx = 0;
        for(int i = 0, j =0; i < len; i++) {
            while(len -i + j > k && j > 0 && ans[j-1] < nums[i]) {
                j--;
            }
            if(j < k) {
                ans[j] = nums[i];
                j++;
            }
        }

        return ans;
    }
}
