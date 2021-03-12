package solutions;

import java.util.*;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        if(A == null || B == null) {
            return new int[0];
        }

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            Deque<Integer> deque = map.getOrDefault(B[i], new LinkedList<>());
            deque.offer(i);
            map.put(B[i], deque);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] res = new int[B.length];

        int i = 0;
        int j = 0, last = B.length - 1;

        while(j <= last && i < A.length) {
            Deque<Integer> indexes;
            if(A[i] <= B[j]) {
                indexes = map.get(B[last]);
                last--;
            } else {
                indexes = map.get(B[j]);
                j++;
            }

            res[indexes.pop()] = A[i];
            i++;
        }

        return res;
    }
}
