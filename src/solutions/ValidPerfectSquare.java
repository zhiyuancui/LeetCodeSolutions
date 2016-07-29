package solutions;

public class ValidPerfectSquare {

	/**
	 * Reference to https://discuss.leetcode.com/topic/49325/a-square-number-is-1-3-5-7-java-code/2
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
        
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
        
    }
}
