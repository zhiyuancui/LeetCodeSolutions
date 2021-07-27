package solutions;

/**
 * 935 Knight Dialer
 * //https://leetcode-cn.com/problems/knight-dialer/solution/4zhuang-tai-dong-tai-gui-hua-pythonjie-kong-jian-f/
 * 即便是long都会溢出
 */
public class KnightDialer {
    public int knightDialer(int n) {
        if(n == 1) {
            return 10;
        }

        long[] states = new long[]{1,1,1,1};

        for(int i = 0; i < n-1; i++) {
            long[] next = new long[4];
            next[0] = states[1] + states[2]; // 1,3,7,9
            next[1] = 2* states[0];// 2, 8
            next[2] = 2*states[0] + states[3]; // 4, 6
            next[3] = 2 * states[2];//0
            states = next;
        }

        return (int)(4*states[0]+2*states[1]+2*states[2]+states[3])%1000000007;

    }
}
