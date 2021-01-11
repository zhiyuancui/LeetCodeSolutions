package solutions;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if(S==null || S.length() == 0) {
            return "";
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()) {
            int count = map.getOrDefault(c,0)+1;
            map.put(c, count);
        }


        StringBuilder sb = new StringBuilder();

        for(char c : S.toCharArray()) {
            if(map.containsKey(c)) {
                int count = map.get(c);
                for(int i = 0; i < count; i++) {
                    sb.append(c);
                }
            }
        }

        for(char c : T.toCharArray()) {
            if(S.indexOf(c) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
