package solutions;

import java.util.HashMap;
import java.util.List;

/**
 * 1773 Count Items Matching a Rule
 */
public class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String, Integer> itemKey = new HashMap<>();
        itemKey.put("type",0);
        itemKey.put("color",1);
        itemKey.put("name",2);

        int key = itemKey.get(ruleKey);
        int count = 0;

        for(List<String> list:items){
            if(list.get(key).equals(ruleValue)) count++;
        }

        return count;
    }
}
