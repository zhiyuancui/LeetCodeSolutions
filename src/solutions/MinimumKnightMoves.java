package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    static int[][] d = new int[][] {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}
    };

    public int minKnightMoves(int x, int y) {
        //we can invert the sign of the number - it doesn't affect the result
        x = Math.abs(x); y = Math.abs(y);
        //store seen cells
        Set<Integer> seen = new HashSet();
        //this is queue for the BFS, initialize it with 0,0 position
        Queue<Integer> q = new LinkedList();
        q.add(0);
        //this will store the number of moves
        int res = 0;
        //start BFS
        while (!q.isEmpty()) {
            //on each step we only poll number of cells that we have in the queue now.
            //everything added after this will be counted at the next step
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //get the encoded num, convert it to coordinated and check if it's our target
                int next = q.poll();
                int curX = (next>>10), curY = next - (curX<<10);
                if (curX == x && curY == y)
                    return res;
                //if not the target - make all possible moves
                for (int k = 0; k < d.length; k++) {
                    //each next move
                    int x1 = curX + d[k][0], y1 = curY + d[k][1];
                    //encode the move to store it in the set of visited cells
                    int curEnc = y1 + (x1<<10);
                    if (x1 >= -2 && y1 >= -2 && seen.add(curEnc)) {
                        q.add(curEnc);
                    }
                }
            }
            //after we done with all moves from all points stored in te queue at the beggining -
            //increment the step counter
            res++;
        }
        return -1;
    }
}
