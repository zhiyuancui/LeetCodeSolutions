package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 527 Word Abbreviation
 */
public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> words) {
        int len = words.size();

        String[] ans = new String[len];
        int[] prefix = new int[len];

        for(int i = 0; i < len; i++) {
            prefix[i] = 1;
            ans[i] = makeAbbr(words.get(i), 1);
        }

        for(int i = 0; i < len; i++) {
            while(true) {
                HashSet<Integer> set = new HashSet<>();

                for(int j = i + 1; j < len; j++) {
                    if(ans[j].equals(ans[i])) {
                        set.add(j);
                    }
                }

                if(set.isEmpty()) {
                    break;
                }
                set.add(i);

                for(int k : set) {
                    ans[k]=makeAbbr(words.get(k), ++prefix[k]);
                }

            }
        }

        return Arrays.asList(ans);
    }

    private String makeAbbr(String s, int k) {
        if (k>=s.length()-2) return s;
        StringBuilder builder=new StringBuilder();
        builder.append(s.substring(0, k));
        builder.append(s.length()-1-k);
        builder.append(s.charAt(s.length()-1));
        return builder.toString();
    }
}
