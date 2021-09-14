package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1298 Maximum Candies You Can Get from Boxes
 */
public class MaximumCandies {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        boolean[] can_open = new boolean[n];
        boolean[] has_box = new boolean[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            can_open[i] = (status[i] == 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        int result = 0;

        for(int box : initialBoxes) {
            has_box[box] = true;
            if(can_open[box]) {
                queue.add(box);
                used[box] = true;
                result += candies[box];
            }
        }

        while(!queue.isEmpty()) {
            int box = queue.poll();

            for(int key : keys[box]) {
                can_open[key] = true;
                if(!used[key] && has_box[key]) {
                    queue.add(key);
                    used[key] = true;
                    result += candies[key];
                }
            }

            for(int next : containedBoxes[box]) {
                has_box[next] = true;
                if (!used[next] && can_open[next]) {
                    queue.add(next);
                    used[next] = true;
                    result += candies[next];
                }
            }
        }

        return result;
    }
}
