package solutions;

/**
 * 1779 Find Nearest Point That Has the Same X or Y Coordinate
 */
public class FindNearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];

            int dx = x - point[0];
            int dy = y - point[1];
            if(dx * dy == 0 && Math.abs(dx+dy) < min) {
                min = Math.abs(dx+dy);
                index = i;
            }
        }

        return index;
    }
}
