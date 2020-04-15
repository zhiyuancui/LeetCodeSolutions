package solutions.amazon;

import java.util.Arrays;

public class TwoSumLessThank {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);

        int left = 0;
        int right = A.length - 1;

        int max = -1;

        while(left < right) {
            if(A[left] + A[right] >= K){
                right--;
            } else {
                max = Math.max(max, A[left]+A[right]);
                left++;
            }
        }

        return max;
    }
}
