package solutions.amazon.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TopKeywords {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for(String word : banned) {
            ban.add(word);
        }

        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().trim();
        String[] paras = paragraph.split("[ ,]+");
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        String word="";
        for(int i=0; i<paras.length; i++)
        {

            if(!ban.contains(paras[i]))
            {

                map.put(paras[i], map.getOrDefault(paras[i],0) +1);
            }

            if(null != map.get(paras[i]) && map.get(paras[i]) > ans)
            {
                ans = map.get(paras[i]);
                word = paras[i];
            }
        }

        return word;
    }
}
