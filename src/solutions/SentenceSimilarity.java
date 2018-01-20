package solutions;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarity {
	public boolean areSentencesSimilarTwo(String[] word1, String[] word2, String[][] pairs) {
        if (word1.length != word2.length) return false;
        Map<String, String> m = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(m, p[0]), parent2 = find(m, p[1]);
            if (!parent1.equals(parent2)) m.put(parent1, parent2);
        }

        for (int i = 0; i < word1.length; i++)
            if (!word1[i].equals(word2[i]) && !find(m, word1[i]).equals(find(m, word2[i]))) return false;

        return true;
    }

    private String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
}
