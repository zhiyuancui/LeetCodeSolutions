package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximumLenOfRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
        int l1 = A.length, l2 = B.length, ans = 0;
        if (l1 == 0 || l2 == 0)
            return 0;        
        HashMap < Integer, List < Integer >> map = new HashMap < > ();
        List < Integer > list;
        for (int i = 0; i < l1; i++) {
            int n = A[i];
            list = map.getOrDefault(n, new ArrayList<Integer>());
            list.add(i);
            map.put(n, list);
        }
        
        for (int i = 0; i < l2 && l2-i > ans; i++) {
            int n = B[i];
            if (map.containsKey(n)){
                list = map.get(n);
                for (int m: list) {
                    if (l1 - m < ans)
                        break;                
                    int count = 1, k = m + 1;
                    for (int j = i + 1; j < l2 && k < l1; j++, k++) {
                        if (B[j] == A[k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    ans = Math.max(ans, count);                
                }
            }
        }

        return ans;
    }
}
