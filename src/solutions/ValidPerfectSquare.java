package solutions;

public class ValidPerfectSquare {

	/**
	 * Reference to https://discuss.leetcode.com/topic/49325/a-square-number-is-1-3-5-7-java-code
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
	
	public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
