package solutions;

import java.util.Arrays;


public class FindMinArrowShots {
	public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //would fail with input [[-2147483646,-2147483645],[2147483646,2147483647]]
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
