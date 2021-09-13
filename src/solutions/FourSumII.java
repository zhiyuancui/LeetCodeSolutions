package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 454 4Sum II
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int count = map.getOrDefault(C[i]+ D[j],0) + 1;
                map.put(C[i]+D[j], count);
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                res += map.getOrDefault(-1*(A[i]+B[j]),0);
            }
        }

        return res;
    }
}
