package solutions.amazon.oa.Sep;

import java.util.Arrays;

public class ParkingCover {
    public int parking(int[] cars, int k) {
        Arrays.sort(cars);

        if(cars.length < k) {
            return -1;
        }

        int result = Integer.MAX_VALUE;

        for(int left = 0; left < cars.length - k + 1; left++) {
            result = Math.min(result, cars[left + k - 1] - cars[left] + 1);
        }

        return result;

    }
}
