package solutions;

/**
 * 1411 Number of Ways to Paint N *3 Grid
 */
public class NumOfWaysToPaint {
    public int numOfWays(int n) {
        int mod = 1000000007;

        long two = 6;
        long three = 6;

        for(int i = 1; i <n; i++) {
            long new_two = two * 3 + three * 2;
            long new_three = two * 2 + three * 2;

            two = new_two % mod;
            three = new_three % mod;
        }

        return (int)((two+three)%mod);
    }
}
