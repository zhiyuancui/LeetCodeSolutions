package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 773 Sliding Puzzle
 */
public class SlidingPuzzle {
    int[][] dirs = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

    public int slidingPuzzle(int[][] board) {
        if(board == null || board.length == 0) {
            return 0;
        }

        String target = "123450";
        Pair start = new Pair(board);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();

        int moves = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if(cur.str.equals(target)) {
                    return moves;
                }
                //System.out.println(cur.str+","+cur.zero);
                for(int dir: dirs[cur.zero]) {
                    String s = swap(cur.str, dir, cur.zero);

                    if(!visited.contains(s)) {
                        Pair next = new Pair(s, dir);
                        queue.add(next);
                        visited.add(s);
                    }
                }

            }
            moves++;
        }

        return -1;
    }

    public String swap(String str, int i, int j) {
        char[] array =  str.toCharArray();

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return new String(array);
    }

    class Pair {
        String str;
        int zero;

        public Pair(String str, int zero) {
            this.str = str;
            this.zero = zero;
        }

        public Pair(int[][] board) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == 0) {
                        this.zero = sb.length();
                    }
                    sb.append(board[i][j]);
                }
            }

            this.str = sb.toString();
        }
    }
}
