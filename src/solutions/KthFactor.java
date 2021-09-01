package solutions;

/**
 * 1492 The kth Factor of n
 * https://leetcode-cn.com/problems/the-kth-factor-of-n/solution/n-de-di-k-ge-yin-zi-by-leetcode-solution/
 */
public class KthFactor {
    public int kthFactor(int n, int k) {
        int count = 0, factor;
        for (factor = 1; factor * factor <= n; ++factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return factor;
                }
            }
        }
        --factor;
        if (factor * factor == n) {
            --factor;
        }
        for (; factor > 0; --factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return n / factor;
                }
            }
        }
        return -1;

    }
}
