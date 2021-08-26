package solutions;

/**
 * 1541 Minimum Insertions to Balance a Parentheses String
 */
public class MinInsertionsToBalanceParentheses {
    public int minInsertions(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                if(right % 2 != 0) {
                    left++;
                    right++;
                } else {
                    right += 2;
                }
            } else if(c == ')') {
                if(right == 0) {
                    left++;
                    right++;
                } else {
                    right--;
                }
            }
        }
        return left + right;
    }
}
