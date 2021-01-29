package solutions;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeArray {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while(idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length) {
            int val1 = arr1[idx1];
            int val2 = arr2[idx2];
            int val3 = arr3[idx3];

            if(val1 == val2 && val2 == val3) {
                result.add(val1);
                idx1++;
                idx2++;
                idx3++;
            } else {
                if(val1 < val2) {
                    idx1++;
                } else if(val2 < val3) {
                    idx2++;
                } else {
                    idx3++;
                }
            }
        }

        return result;
    }
}
