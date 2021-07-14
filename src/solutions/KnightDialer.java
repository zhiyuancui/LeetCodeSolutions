package solutions;

/**
 * 935 Knight Dialer
 * //https://leetcode-cn.com/problems/knight-dialer/solution/4zhuang-tai-dong-tai-gui-hua-pythonjie-kong-jian-f/
 *
 */
public class KnightDialer {
    public int knightDialer(int n) {
        if(n == 1) {
            return 10;
        }

        long[] states = new long[]{1,1,1,1};

        for(int i = 0; i < n-1; i++) {
            long[] next = new long[4];
            next[0] = states[1] + states[2];
            next[1] = 2* states[0];
            next[2] = 2*states[0] + states[3];
            next[3] = 2 * states[2];
            states = next;
        }

        return (int)(4*states[0]+2*states[1]+2*states[2]+states[3])%1000000007;

    }
}
