package solutions;

public class CountNumber {

	/**
	 * Reference to: https://discuss.leetcode.com/topic/48332/java-o-1-with-explanation/2
	 * 
	 * @param n
	 * @return
	 */
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
        	return 1;
        }
        //ans is from 0 to 9;
        
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
        	base = base * (9 - i + 2);
        	ans += base;
        }
        return ans;
    }
}
