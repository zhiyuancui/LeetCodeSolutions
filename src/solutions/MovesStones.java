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
}
