package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        if(wordlist == null || queries == null) {
            return new String[0];
        }

        String[] ans = new String[queries.length];

        HashMap<String, String> wordMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();
        Set<String> words = new HashSet<>();

        for(String word : wordlist) {
            words.add(word);

            String low = word.toLowerCase();
            wordMap.putIfAbsent(low, word);

            String vowel = decode(low);
            vowelMap.putIfAbsent(vowel, word);
        }


        for(int i = 0; i < queries.length; i++) {
            if(words.contains(queries[i])) {
                ans[i] = queries[i];
                continue;
            }

            String lower = queries[i].toLowerCase();
            if(wordMap.containsKey(lower)) {
                ans[i] = wordMap.get(lower);
                continue;
            }

            String vowel = decode(lower);
            if(vowelMap.containsKey(vowel)) {
                ans[i] = vowelMap.get(vowel);
            }   else {
                ans[i] = "";
            }

        }

        return ans;
    }

    private String decode(String word) {
        return word.replaceAll("[aeiou]", "#");
    }
}
