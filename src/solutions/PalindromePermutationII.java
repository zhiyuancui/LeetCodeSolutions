package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {
    /**
     * Given a string s, return all the palindromic permutations (without duplicates) of it.
     * Return an empty list if no palindromic permutation could be form.
     * For example:
     * Given s = "aabb", return ["abba", "baab"].
     * Given s = "abc", return [].
     *
     * Reference to : https://leetcode.com/discuss/questions/oj/palindrome-permutation-ii?start=20
     *
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> result = new ArrayList<String>();
        List<Character> list = new ArrayList<Character>();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        if( odd > 1 ){
            return result;
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet() ){
            char key = entry.getKey();
            int val = entry.getValue();

            if( val % 2 != 0 ){
                mid += key;
            }

            for(int i = 0; i < val / 2; i++){
                list.add(key);
            }
        }

        perm(list, mid, new boolean[ list.size() ], new StringBuilder(), result);

        return result;
    }

    private void perm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> result){
        if( sb.length() == list.size() ){
            result.add(sb + mid + sb.reverse());
            sb.reverse();
            return;
        }

        for(int i = 0; i < list.size(); i++){
            if( i > 0 && list.get(i) == list.get(i-1) && !used[i-1] ){
                continue;
            }

            if( !used[i] ){
                used[i] = true;
                sb.append(list.get(i));
                perm(list,mid,used,sb,result);
                used[i] = false;
                sb.deleteCharAt( sb.length() - 1 );
            }
        }
    }
}
