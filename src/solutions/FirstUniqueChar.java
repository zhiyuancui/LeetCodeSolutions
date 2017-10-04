package solutions;

public class FirstUniqueChar {
	public int firstUniqChar(String s) {
        
        if( s == null || s.length() == 0 ) {
            return -1;
        }
        
        int[] freq = new int[26];
        for(char c : s.toCharArray() ) {
            freq[c-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if( freq[s.charAt(i) - 'a'] == 1 ) {
                return i;
            }
        }
        
        return -1;
        
    }
}
