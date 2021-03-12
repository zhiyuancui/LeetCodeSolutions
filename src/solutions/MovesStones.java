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

        if(stones[stones.length - 1] - stones[0] + 1 == stones.length) {
            return new int[]{0,0};
        }

        int len = stones.length;

        int max = 1 + Math.max(stones[len-1] - stones[1] + 1 -len, stones[len-2]-stones[0]+1-len);
        int min = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(stones[0]);

        for(int i = 1; i < stones.length; i++) {
            if(stones[i] - queue.peek() + 1>= len) {
                if(stones[i] - queue.peek() + 1 == len) {
                    min = Math.min(min, len - queue.size() -1);
                } else {
                    if(stones[i] - queue.peek() == len) {
                        min = 1;
                    } else {
                        int m = Math.max(2, len - queue.size());
                        min = Math.min(min, m);
                    }
                }
                queue.poll();
            }
            queue.add(stones[i]);
        }

        return new int[]{min, max};
    }
}
