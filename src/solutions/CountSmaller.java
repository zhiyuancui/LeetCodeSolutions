package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count of Smaller Numbers After Self
 * https://www.youtube.com/watch?v=z-uLlQMvOVM&t=1088s
 */
public class CountSmaller {
    int[] sortedNums;
    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        sortedNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }

        counts = new int[nums.length];

        divideConque(nums,  0, nums.length - 1);

        List<Integer> result = new ArrayList<>();
        for(int i : counts) {
            result.add(i);
        }

        return result;
    }

    private void divideConque(int[] nums, int start, int end) {
        if(start == end) {
            return;
        }

        int mid = start + (end-start) / 2;

        divideConque(nums, start, mid);
        divideConque(nums, mid+1, end);

        for(int i = start; i <= mid; i++) {
            int val = nums[i];
            int pos = findLastSmaller(mid+1, end, val);
            counts[i] += pos - (mid+1);
        }

        Arrays.sort(sortedNums, start, end+1);
    }

    private int findLastSmaller(int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(sortedNums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start > end ? end + 1 : -1;
    }
}
