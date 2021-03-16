package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        if(board == null || board.length == 0) {
            return 0;
        }

        String target = "123450";
        int[][] dirs = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        Pair fp = new Pair();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    fp.zeroPos = sb.length();
                }
                sb.append(board[i][j]);
            }
        }


        fp.str = sb.toString();

        Set<String> visited = new HashSet<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(fp);

        visited.add(fp.str);

        while(!queue.isEmpty()) {
            Pair rp = queue.poll();
            if(rp.str.equals(target)) {
                return rp.moves;
            }

            for(int dir: dirs[rp.zeroPos]) {
                String s = swap(rp.str, dir, rp.zeroPos);

                if(!visited.contains(s)) {
                    Pair next = new Pair(s, dir, rp.moves+1);
                    queue.add(next);
                    visited.add(s);
                }
            }
        }

        return -1;
    }

    public String swap(String str, int i, int j) {
        char[] array = str.toCharArray();

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return new String(array);
    }

    class Pair {
        String str;
        int zeroPos;
        int moves = 0;

        public Pair(String str, int zeroPos, int moves) {
            this.str = str;
            this.zeroPos = zeroPos;
            this.moves = moves;
        }

        public Pair(){}
    }
}
