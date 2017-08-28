package solutions;

import java.util.Arrays;

public class Heaters {
	/**
	 * Arrays.binarySearch :http://blog.csdn.net/cxhply/article/details/49423501
	 * Reference to : http://blog.csdn.net/styshoo/article/details/53915200
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
            		index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;//left
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;//right
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
}
