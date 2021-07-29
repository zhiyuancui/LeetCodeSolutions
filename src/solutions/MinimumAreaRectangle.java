package solutions;

import java.util.*;


/**
 * 939 Minimum Area Rectangle
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        SortedMap<Integer, Set<Integer>> xToYPoints = calc(points);
        int result = Integer.MAX_VALUE;
        for (int x: xToYPoints.keySet()) {
            Set<Integer> yPoints = xToYPoints.get(x);
            if (yPoints.size() < 2) continue;
            // keys are greater and equal to input
            for (int nextX: xToYPoints.tailMap(x + 1).keySet()) {
                Set<Integer> nextYPoints = xToYPoints.get(nextX);
                if (nextYPoints.size() < 2) continue;

                SortedSet<Integer> candidates = new TreeSet<>(yPoints);
                //包含nextYpoints
                candidates.retainAll(nextYPoints);

                int width = nextX - x;
                int prevValue = -1;
                for (int candidate: candidates) {
                    if (prevValue != -1) {
                        int height = candidate - prevValue;
                        result = Math.min(result, height * width);
                    }
                    prevValue = candidate;
                }
            }
        }
        return (result == Integer.MAX_VALUE)? 0: result;
    }

    private SortedMap<Integer, Set<Integer>> calc(int[][] points) {
        SortedMap<Integer, Set<Integer>> result = new TreeMap<>();
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            Set<Integer> yPoints = result.computeIfAbsent(x, p -> new HashSet<>());
            yPoints.add(y);
        }
        return result;
    }
}
