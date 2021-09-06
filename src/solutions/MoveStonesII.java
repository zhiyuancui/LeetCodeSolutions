package solutions;

import java.util.Arrays;

public class MoveStonesII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);

        int len = stones.length;

        int max = stones[len - 1] - stones[0] + 1 - len;
        max -= Math.min(stones[len-1] - stones[len-2] - 1, stones[1] - stones[0] - 1);

        int min = max;
        int i = 0;
        int j = 0;

        for(i = 0; i < len; i++) {
            while(j+1 < len && stones[j+1] - stones[i] + 1 <= len) {
                j++;
            }
            int cost = len - (j - i + 1);
            if(j - i + 1 == len - 1 && stones[j] - stones[i] + 1 == len - 1) {
                cost = 2;
            }
            min = Math.min(min, cost);
        }

        return new int[]{min, max};
    }
}
