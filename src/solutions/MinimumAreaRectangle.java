package solutions;

import java.util.*;

// https://leetcode.com/problems/minimum-area-rectangle/discuss/992992/JavaNaive-SolutionOn2-Easy-to-Understand
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> sameX = new HashMap<>();
        Map<Integer, List<Integer>> sameY = new HashMap<>();

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];

            sameX.putIfAbsent(x, new ArrayList<>());
            sameY.putIfAbsent(y, new ArrayList<>());

            sameX.get(x).add(y);
            sameY.get(y).add(x);
        }


        for(int x: sameX.keySet()) {
            if(sameX.get(x).size() == 1) {
                continue;
            }

            List<Integer> list = sameX.get(x);

            for(int j = 0; j < list.size(); j++) {
                for(int k = j +1; k < list.size(); k++) {
                    int y1 = list.get(j);
                    int y2 = list.get(k);
                    if(y1 == y2 || !sameY.containsKey(y1) || !sameY.containsKey(y2) || sameY.get(y1).size() < 2 || sameY.get(y2).size() < 2) {
                        continue;
                    }

                    Set<Integer> commonX = new HashSet<>();
                    Set<Integer> set1 = new HashSet<>();
                    for(int m : sameY.get(y1)) {
                        set1.add(m);
                    }
                    for (int m : sameY.get(y2)) {
                        if (set1.contains(m)) {
                            commonX.add(m);
                        }
                    }

                    for (int x1 : commonX) {
                        if (x1 == x) {
                            continue;
                        }
                        min = Math.min(min, Math.abs(x1 - x) * Math.abs(y1 - y2));
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
