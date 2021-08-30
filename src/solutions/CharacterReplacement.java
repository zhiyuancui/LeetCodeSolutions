package solutions;

/**
 * 424 Longest Repeating Character Replacement
 */
public class CharacterReplacement {
	public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] count = new int[26];

        int left = 0;
        int maxCount = 0;
        int maxLen = 0;

        for(int right = 0; right < len; right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while(right - left + 1 > k + maxCount) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
