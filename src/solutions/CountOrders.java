package solutions;

/**
 * 1359 Count All Valid Pickup and Delivery Options
 * https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options/solution/you-xiao-de-kuai-di-xu-lie-shu-mu-by-leetcode-solu/
 */
public class CountOrders {
    public int countOrders(int n) {
        if(n <= 0) {
            return 0;
        }

        long result = 1, mod = (long)1e9+7;

        for(int i = 1; i <= n; i++) {
            result = result * (i * 2 - 1) * i % mod;
        }

        return (int)result;
    }
}
