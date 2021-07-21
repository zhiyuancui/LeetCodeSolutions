package solutions.amazon;

import java.util.Arrays;

/**
 * 973 K Closest Points to Origin
 */
public class KCloestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while(left < right) {
            int mid = sort(left, right, points);
            if(mid < k) {
                left = mid + 1;
            } else if(mid > k){
                right = mid - 1;
            } else {
                break;
            }
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    public int sort(int left, int right, int[][] points) {
        int[] pivot = points[left];

        while(left < right) {
            while(left < right && compare(points[right], pivot) >= 0) {
                right--;
            }
            points[left] = points[right];
            while(left < right && compare(points[left], pivot) <= 0) {
                left++;
            }

            points[right] = points[left];
        }

        points[left] = pivot;

        return left;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1]* p1[1] - p2[0] * p2[0] - p2[1]*p2[1];
    }
}
