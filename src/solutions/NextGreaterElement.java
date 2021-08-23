package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496 Next Greater Element
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
