package solutions;

/**
 * 1614 Maximum Nesting Depth of the Parentheses
 */
public class MaximumNestDepth {
    public int maxDepth(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int count = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
                max = Math.max(max, count+1);
            }
        }

        return max;
    }
}
