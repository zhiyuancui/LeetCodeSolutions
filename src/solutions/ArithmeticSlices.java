package solutions;

public class ArithmeticSlices {

	/**
	 * Reference to : https://discuss.leetcode.com/topic/63302/simple-java-solution-9-lines-2ms
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
        	if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
        		curr += 1;
        		sum += curr;
        	} else {
        		curr = 0;
        }
        return sum;
    }
}
