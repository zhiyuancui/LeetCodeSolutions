package solutions;

public class FindDerangement {
	private static final int M = 1000000007;
    public int findDerangement(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) 
            ans = (i * ans % M + (i % 2 == 0 ? 1 : -1)) % M;
        return (int) ans;
    }
}
