package solutions;

public class UniqueSubstrInWraproundStr {
	/**
	 * Reference to: https://discuss.leetcode.com/topic/70658/concise-java-solution-using-dp
	 * reference to： http://www.cnblogs.com/grandyang/p/6143071.html
	 * @param p
	 * @return
	 */
	public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        
        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
