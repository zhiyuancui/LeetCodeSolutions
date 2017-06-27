package solutions;

public class RotateFunction {

	/**
	 * Reference to: https://discuss.leetcode.com/topic/58459/java-o-n-solution-with-explanation
	 * @param A
	 * @return
	 */
	public int maxRotateFunction(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;   
    }
}
