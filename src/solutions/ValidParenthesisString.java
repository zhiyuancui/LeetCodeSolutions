package solutions;

/**
 * 678 Valid Parenthesis String
 */
public class ValidParenthesisString {
    public boolean checkValidString2(String s) {
        int left = 0, right = 0, size = s.length();
        for(int i = 0; i < size; ++i)
        {
            left  += (s.charAt(i) == ')') ? -1 : +1;            //从左向右看左括号能否有效
            right += (s.charAt(size-1-i) == '(') ? -1 : +1;     //从右向左看右括号能否有效
            if(left < 0 || right < 0)   return false;
        }
        return true;
    }

}
