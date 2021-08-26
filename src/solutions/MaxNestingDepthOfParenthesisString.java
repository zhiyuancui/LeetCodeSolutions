package solutions;

/**
 * 1111 Maximum Nesting Depth of Two Valid Parentheses Strings
 */
public class MaxNestingDepthOfParenthesisString {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] result = new int[len];

        int left = 0;

        for(int i = 0; i < len; i++) {
            if(seq.charAt(i) == ')') {
                left--;
            }
            result[i] = left % 2;
            if(seq.charAt(i) == '(') {
                left++;
            }
        }

        return result;
    }
}
