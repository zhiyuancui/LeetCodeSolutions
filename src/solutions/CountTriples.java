package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1925 Count Square Sum Triples
 */
public class CountTriples {
    public int countTriples(int n) {
        int ans = 0;

        Set<Integer> set = new HashSet<>();

        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i * i;
            set.add(arr[i]);
        }

        for(int i = 5; i <= n; i++) {
            int t = (int) Math.sqrt(arr[i]/2) + 1;
            for(; t < i; t++) {
                if(set.contains(arr[i] - arr[t])) {
                    ans++;
                }
            }
        }

        return ans * 2;
    }
}
