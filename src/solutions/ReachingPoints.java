package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 780 Reaching Points
 */
public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty) {
            return true;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});

        while(!queue.isEmpty()) {
            int size = queue.size();
            //System.out.println("/////////////////////");
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                //System.out.println(cur[0] +" : "+cur[1]);
                if(cur[0] == tx && cur[1] == ty) {
                    return true;
                }

                int incre = cur[1];
                if(cur[0]+incre <= tx && cur[1] <= ty) {
                    queue.add(new int[]{cur[0]+incre, cur[1]});
                }

                if(cur[0] <= tx && cur[0] + incre <= ty) {
                    queue.add(new int[]{cur[0], cur[0]+incre});
                }
            }
        }

        return false;
    }

    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        } else if (tx == ty || sx > tx || sy > ty) {
            return false;
        } else if (tx > ty) {
            int subtract = Math.max(1, (tx - sx)/ty);
            return reachingPoints(sx, sy, tx - subtract * ty, ty);
        } else {
            int subtract = Math.max(1, (ty - sy)/tx);
            return reachingPoints(sx, sy, tx, ty - subtract * tx);
        }
    }
}
