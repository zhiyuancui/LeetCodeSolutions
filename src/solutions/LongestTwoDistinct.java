package solutions;

import java.util.HashMap;

public class LongestTwoDistinct {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int low = 0;
        int high = 0;
        int maxLength = 0;
        while(high < s.length()) {
            if( index.size() <= 2 ) {
                char c = s.charAt(high);
                index.put(c, high);
                high++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                low = leftMost+1;
            }
            maxLength = Math.max(maxLength, high-low);
        }
        return maxLength;
    }
}
