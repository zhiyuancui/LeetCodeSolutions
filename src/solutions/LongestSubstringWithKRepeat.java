package solutions;

public class LongestSubstringWithKRepeat {
	/**
	 * Longest Substring With At Least K Repeating Characters
	 * Reference to: https://discuss.leetcode.com/topic/57372/java-divide-and-conquer-recursion-solution
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	 if(s == null || s.length() == 0 ) {
        return 0;
    }

    char[] str = s.toCharArray();

    int maxUnique = getMaxUnique(s);

    int max = 0;

        for(int i = 1; i <= maxUnique; i++) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int unique = 0;
        int countAtLeastK = 0;

        while(right < str.length) {
            if(unique <= i) {
                int idx = str[right] - 'a';
                if(count[idx] == 0) {
                    unique++;
                }
                count[idx]++;
                if(count[idx] == k) {
                    countAtLeastK++;
                }
                right++;
            } else {
                int idx = str[left] - 'a';
                if(count[idx] == k) {
                    countAtLeastK--;
                }
                count[idx]--;
                if(count[idx] == 0) {
                    unique--;
                }
                left++;
            }
            if(unique == i && unique == countAtLeastK) {
                max = Math.max(right - left, max);
            }
        }
    }

        return max;
}

    private int getMaxUnique(String s) {
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            set.add(c);
        }

        return set.size();
    }
}
