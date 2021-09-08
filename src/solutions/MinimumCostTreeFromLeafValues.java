package solutions;

import java.util.Stack;

/**
 * 1130 Minimum Cost Tree From Leaf Values
 * https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/wei-shi-yao-dan-diao-di-jian-zhan-de-suan-fa-ke-xi/
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(Integer.MAX_VALUE);

        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            while(arr[i] >= stack.peek()) {
                result += stack.pop() * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }

        while(stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }

        return result;
    }
}
