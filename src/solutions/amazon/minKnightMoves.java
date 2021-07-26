package solutions.amazon;

import java.util.*;

/**
 * 1197 Minimum Knight Moves
 */
public class minKnightMoves {

    int[] dx = new int[]{2,2,-2,-2,1,1,-1,-1};
    int[] dy = new int[]{1,-1,1,-1,2,-2,-2,2};
    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        Set<Integer> visited = new HashSet<>();

        int steps = 0;
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                visited.add(cur[0] * 1000 + cur[1]);
                if(cur[0] == x && cur[1] == y) {
                    return steps;
                }

                for(int j = 0; j < dx.length; j++) {
                    int newX = cur[0] + dx[j];
                    int newY = cur[1] + dy[j];

                    if(newX >= -1 && newY >= -1 && !visited.contains(newX * 1000 + newY)) {
                        queue.add(new int[]{newX, newY});
                        visited.add(newX * 1000 + newY);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    /**
     * 最优解 用map优化
     * @param x
     * @param y
     * @return
     */
    public int minKnightMoves2(int x, int y) {
        Map<String,Integer> posToMoveCount = new HashMap<>();
        posToMoveCount.put("0-0", 0);
        return getMinMoves(x, y, posToMoveCount);
    }

    public int getMinMoves(int x, int y, Map<String, Integer> posToMoveCount) {
        x = Math.abs(x);
        y = Math.abs(y);

        String pos = x + "-" + y;
        if (posToMoveCount.containsKey(pos)) {
            return posToMoveCount.get(pos);
        }

        if (x + y == 2) {
            return 2;
        }

        int count = Math.min(getMinMoves(x-1, y-2, posToMoveCount)+1, getMinMoves(x-2, y-1, posToMoveCount)+1);
        posToMoveCount.put(pos, count);
        return count;
    }
}
