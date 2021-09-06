package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 784 Letter Case Permutation
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(result, s, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String s, String cur, int pos) {
        if(pos == s.length()) {
            result.add(cur);
            return;
        }

        char c = s.charAt(pos);
        if(Character.isLetter(c) ){
            backtrack(result,s, cur+Character.toLowerCase(c), pos+1);
            backtrack(result,s, cur+Character.toUpperCase(c), pos+1);
        } else {
            backtrack(result, s, cur+c, pos+1);
        }
    }
}
