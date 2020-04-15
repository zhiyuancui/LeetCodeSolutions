package solutions.amazon;

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {

        if(N == 0)
            return cells;

        int m = cells.length;

        if(N == 1)
            return cells;

        N--;
        boolean repeat = false;
        int episodes = 0;
        int[] next = cells;
        while(!repeat && N!=0){
            next = transition(next, m);
            N--;
            repeat = Arrays.equals(cells, next);
            episodes++;
        }

        if(N==0)
            return next;

        N = N % episodes;
        while(N!=0){
            next = transition(next, m);
            N--;
        }
        return next;
    }

    int[] transition(int[] prev, int m){
        int[] next = new int[m];
        // edges are constant
        next[0] = 0;
        next[m-1] = 0;
        // other cells changes
        for(int i=1;i<m-1;i++){
            next[i] = prev[i-1] == prev[i+1] ? 1 : 0;
        }
        return next;
    }
}
