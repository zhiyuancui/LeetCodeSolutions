package solutions;

/**
 * 1347 Minimum Number of Steps to Make Two Strings Anagram
 */
public class MinimumNumberToMakeAnagram {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            map[c - 'a']--;
        }

        int res = 0;
        for(int i = 0; i < 26;i++){
            res += Math.abs(map[i]);
        }

        return res / 2;
    }
}
