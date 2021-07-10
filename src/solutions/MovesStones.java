package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MovesStones {
    public int[] numMovesStones(int a, int b, int c) {
        int[] sorted = new int[]{a,b,c};
        Arrays.sort(sorted);

        int min = 0;
        int max = 0;
        if(sorted[0] + 1 == sorted[1] && sorted[1] == sorted[2] -1) {
            min = 0;
        } else if(sorted[1] - sorted[0] > 2 && sorted[2] - sorted[1] > 2) {
            min = 2;
        } else {
            min = 1;
        }

        max = sorted[2] - sorted[0] - 2;

        return new int[]{min, max};
    }

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
