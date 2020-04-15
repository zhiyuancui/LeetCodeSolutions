package solutions.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products, (a, b)-> a.compareTo(b));

        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0,i+1);
            List<String> solution = new ArrayList<>();
            int count = 0;
            for(String product : products) {
                if(samePrefix(product, prefix) && count < 3) {
                    solution.add(product);
                    count++;
                }
            }
            result.add(new ArrayList<>(solution));
        }

        return result;

    }

    private boolean samePrefix(String s, String prefix) {
        for(int i = 0; i < prefix.length(); i++) {
            if( i >= s.length() || s.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
