package solutions.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Integer> steps = new HashMap<>();

        steps.put(1,0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            if(start == n*n) {
                return steps.get(start);
            }

            for(int next = start +1; next <= Math.min(start+6, n*n); next++) {
                int[] index = get(next, n);

                int row = index[0];
                int col = index[1];
                int last = board[row][col] == -1 ? next: board[row][col];
                if(!steps.containsKey(last)) {
                    steps.put(last, steps.get(start) + 1);
                    queue.add(last);
                }
            }
        }

        return -1;
    }

    public int[] get(int s, int n) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int row = n - ((s-1) / n )- 1;
        int col = row % 2 != n %2 ? (s-1) % n : n - 1- (s-1)%n;
        return new int[]{row, col};
    }
}
