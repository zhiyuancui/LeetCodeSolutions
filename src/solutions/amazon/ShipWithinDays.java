package solutions.amazon;

/**
 * 1011 Capacity to Ship Packages Within D Days
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight: weights) {
            left = Math.max(weight, left);
            right += weight;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;

            int need = 1, cur = 0;

            for(int weight : weights) {
                if(cur+weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }

            if(need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
