package solutions;

/**
 * K-th Symbol in Grammar
 */
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
    }
}
