package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class StringIterator {
	Queue<int[]> queue = new LinkedList<>();
    
    public StringIterator(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            int j = i+1;
            while (j < n && s.charAt(j) - 'A' < 0) j++;
            queue.add(new int[]{s.charAt(i) - 'A',  Integer.parseInt(s.substring(i+1, j))});
            i = j;
        }
    }
    
    public char next() {
        if (queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if (--top[1] == 0) queue.poll();
        return (char) ('A' + top[0]);
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
