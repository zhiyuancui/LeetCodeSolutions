package solutions;

/**
 * 1400 Construct K Palindrome Strings
 */
public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        int right = s.length();

        int[] count = new int[26];

        for(char c : s.toCharArray()) {
            count[c -'a']++;
        }

        int left = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i] % 2 == 1) {
                left++;
            }
        }

        left = Math.max(left, 1);

        return left <= k && k <= right;
    }
}
