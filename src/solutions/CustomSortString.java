package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 791 Custom Sort String
 */
public class CustomSortString {
    public String customSortString(String order, String T) {
        if(order==null || order.length() == 0) {
            return "";
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()) {
            int count = map.getOrDefault(c,0)+1;
            map.put(c, count);
        }


        StringBuilder sb = new StringBuilder();

        for(char c : order.toCharArray()) {
            if(map.containsKey(c)) {
                int count = map.get(c);
                for(int i = 0; i < count; i++) {
                    sb.append(c);
                }
            }
        }

        for(char c : T.toCharArray()) {
            if(order.indexOf(c) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
