package solutions;

import java.util.List;

/**
 * 425 Valid Word Squares
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) {
            return true;
        }

        int n = words.size();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < words.get(i).length(); j++) {
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
