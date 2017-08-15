package solutions;

public class SortTransformedArray {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0, right = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (left <= right) {
            if (a >= 0) {
                sorted[index] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[left++], a, b, c) : quad(nums[right--], a, b, c);
                index--;
            } else {
                sorted[index] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[right--], a, b, c) : quad(nums[left++], a, b, c);
                index++;
            }
        }
        return sorted;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
