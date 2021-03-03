package solutions.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if(workers == null || bikes == null) {
            return new int[0];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });

        int[] result = new int[workers.length];

        for(int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for(int j =0; j < bikes.length; j++) {
                int dist = getDistance(worker[0], worker[1], bikes[j][0], bikes[j][1]);
                queue.add(new int[]{dist, i, j});
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);

        // assign the bikes.
        Set<Integer> bikeAssigned = new HashSet<>();

        while (bikeAssigned.size() < workers.length) {
            int[] pair = queue.poll();
            if (res[pair[1]] == -1
                    && !bikeAssigned.contains(pair[2])) {

                res[pair[1]] = pair[2];
                bikeAssigned.add(pair[2]);
            }
        }

        return res;
    }



    private int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
