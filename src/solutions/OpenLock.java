package solutions;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        Set<Integer> visited = new HashSet<>();

        for(String deadend : deadends) {
            visited.add(Integer.parseInt(deadend));
        }

        int t = Integer.parseInt(target);
        if(visited.contains(0)) {
            // 0000 is deadend
            return -1;
        }

        int turns = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();

                for(int j = 1; j < 10000; j *=10) {
                    int digit = curr % (j*10) /j, remain = curr - (digit*j);

                    for(int k = 1; k < 10; k+=8) {
                        int next = remain + (digit + k) %10 * j;
                        if(visited.contains(next)) {
                            continue;
                        }
                        if(next == t) {
                            return turns;
                        }
                        visited.add(next);
                        queue.add(next);
                    }

                }
            }
            turns++;
        }

        return -1;
    }
}
