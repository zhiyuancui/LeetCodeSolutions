package solutions.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1481 Least Number of Unique Integers after K Removals
 */
public class LeastNumberofUnique {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<Integer> freqs = map.values().stream().sorted().collect(Collectors.toList());
        int count = 0, idx = 0;
        while (idx < freqs.size() && k - freqs.get(idx) >= 0) {
            k -= freqs.get(idx);
            count++;
            idx++;
        }
        return freqs.size() - count;
    }
}
