package solutions;

/**
 * 921 Minimum Add to Make Parentheses Valid
 */
public class MinimumAddToValidParentheses {
    public int minAddToMakeValid(String S) {
        if(S == null || S.length() == 0) {
            return 0;
        }

        int ans = 0, bal = 0;

        for(char c : S.toCharArray()) {
            bal += c == '(' ? 1 :-1;
            if(bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}
