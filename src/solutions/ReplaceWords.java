package solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;
        
        Set<String> set = new HashSet<>();
        for (String s : dict) set.add(s);
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            sb.append(" " + prefix);
        }
        
        return sb.deleteCharAt(0).toString();
    }
}
