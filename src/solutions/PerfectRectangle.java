package solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PerfectRectangle {
	public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0) {
            return false;
        }

        Set<int[]> set = new TreeSet<>((int[] a, int[]b) -> {
            if(a[3] <= b[1]) {
                return -1;
            } else if(a[1] >= b[3]) {
                return 1;
            } else if(a[2] <= b[0]) {
                return -1;
            } else if(a[0] >= b[2]) {
                return 1;
            } else {
                return 0;
            }
        });

        int area = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int[] rect: rectangles) {
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);

            if(!set.add(rect)) {
                return false;
            }
        }

        return (maxY - minY) * (maxX - minX) == area;
    }
}
