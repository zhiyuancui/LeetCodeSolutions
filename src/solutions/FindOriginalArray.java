package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2007 Find Original Array From Doubled Array
 */
public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);

        Queue<Integer> queue = new LinkedList<>();

        if(changed.length % 2 != 0) {
            return new int[]{};
        }

        int[] res = new int[changed.length / 2];
        int idx = 0;
        for(int i = 0; i < changed.length; i++) {
            if(queue.isEmpty()) {
                queue.add(changed[i]);
            } else {
                if(queue.peek() * 2 == changed[i]) {
                    res[idx] = queue.poll();
                    idx++;
                } else {
                    queue.add(changed[i]);
                }
            }
        }

        if(!queue.isEmpty()) {
            return new int[]{};
        }

        return res;
    }
}
