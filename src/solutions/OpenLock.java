package solutions;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if(deadends == null) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(new String("0000"));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();

                if(cur.equals(target)) {
                    return level;
                }

                for(String next: findNext(cur, deadends, visited)) {
                    queue.add(next);
                }
            }
            level++;
        }

        return -1;

    }


    private List<String> findNext(String str, String[] deadends, Set<String> visited) {
        char[] array = str.toCharArray();
        List<String> result = new ArrayList<>();

        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        if(deadend.contains(str)) {
            return new ArrayList<>();
        }

        for(int i = 0; i < array.length; i++) {
            String next = turn(array, i, 1);
            String prev = turn(array, i,-1);
            if(!deadend.contains(next) && !visited.contains(next)) {
                visited.add(next);
                result.add(next);
            }
            if(!deadend.contains(prev) && !visited.contains(prev)) {
                visited.add(prev);
                result.add(prev);
            }
        }

        return result;
    }

    private String turn(char[] array, int pos, int offset) {
        char[] clone = clone(array);
        if(clone[pos] > '0' && clone[pos] < '9') {
            clone[pos] += offset;
        } else if(clone[pos] == '0') {
            if(offset > 0) {
                clone[pos] = '1';
            } else {
                clone[pos] = '9';
            }
        } else {
            if(offset > 0) {
                clone[pos] = '0';
            } else {
                clone[pos] = '8';
            }
        }

        return new String(clone);

    }

    private char[] clone(char[] array) {
        char[] clone = new char[array.length];
        for(int i = 0; i < array.length; i++) {
            clone[i] = array[i];
        }

        return clone;
    }
}
