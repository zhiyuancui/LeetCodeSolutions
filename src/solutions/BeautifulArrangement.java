package solutions;

public class BeautifulArrangement {

	
	int count = 0;
    
	/**
	 * Reference to : https://discuss.leetcode.com/topic/79916/java-solution-backtracking
	 * @param N
	 * @return
	 */
    public int countArrangement(int N) {
        if( N == 0) {
            return 0;
        }
        helper(N, 1, new int[N + 1]);
        return count;
    }
    
    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
    
    /**
     * 
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0? l++ : r--);
        return res;
    }
}
