package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 386 Lexicographical Numbers
 */
public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        lexicalOrder(result, n, 1);

        return result;
    }

    public void lexicalOrder(List<Integer> result, int max, int cur) {
        if(cur > max) {
            return;
        }

        result.add(cur);
        lexicalOrder(result, max, cur * 10);

        if(cur % 10 < 9) {
            lexicalOrder(result, max, cur + 1);
        }
    }
}
