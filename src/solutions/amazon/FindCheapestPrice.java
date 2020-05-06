package solutions.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> nextFlights = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nextFlights.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            nextFlights.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[][] f = new int[K + 2][n];
        for (int k = 0; k <= K + 1; k++) {
            for (int i = 0; i < n; i++) {
                if (i == src) {
                    f[k][i] = 0;
                } else {
                    f[k][i] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 0; k < K + 1; k++) {
            for (int i = 0; i < n; i++) {
                if (f[k][i] != Integer.MAX_VALUE) {
                    for (int[] flight : nextFlights.get(i)) {
                        f[k+1][flight[0]] = Math.min(f[k + 1][flight[0]], f[k][i] + flight[1]);
                    }
                }
            }
        }
        return f[K + 1][dst] == Integer.MAX_VALUE? -1 : f[K+1][dst];
    }

}
