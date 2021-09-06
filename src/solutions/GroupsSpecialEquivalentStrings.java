package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893 Groups of Special-Equivalent Strings
 */
public class GroupsSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        int eLen = 0, oLen = 0;
        for(String word: words) {
            if(word.length()%2 == 1) {
                eLen = word.length()/2+1;
            } else
                eLen = word.length()/2;
            oLen = word.length()/2;
            char[] even = new char[eLen];
            char[] odd = new char[oLen];

            int e = 0, o = 0;
            for(int i =0; i< word.length(); i++) {
                if(i%2 == 0)
                    even[e++] = word.charAt(i);
                else
                    odd[o++] = word.charAt(i);
            }
            Arrays.sort(even);
            Arrays.sort(odd);

            String s = new String(even) + new String(odd);
            set.add(s);
        }

        return set.size();
    }
}
