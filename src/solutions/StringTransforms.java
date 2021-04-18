package solutions;

import java.util.HashMap;
import java.util.Map;

public class StringTransforms {
    public boolean canConvert(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        if(str1.equals(str2)) {
            return true;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if(map1.containsKey(c1) && !map2.containsKey(c2)) {

                return false;
            }

            if((map1.containsKey(c1) && map2.containsKey(c2)) && (map1.get(c1) != c2 || map2.get(c2) != c1) ) {
                return false;
            }

            map1.put(c1,c2);
            map2.put(c2, c1);
        }

        if(map2.size() == 26) {
            return false;
        }

        return true;
    }
}
