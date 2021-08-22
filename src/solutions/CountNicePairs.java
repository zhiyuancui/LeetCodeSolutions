package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814 Count Nice Pairs in an Array
 */
public class CountNicePairs {
    public int countNicePairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = (int)1e9 + 7;

        for(int num : nums) {
            int diff = num - reverse(num);
            int count = map.getOrDefault(diff, 0);
            map.put(diff, count + 1);

            res = (res+count) % mod;
        }

        return res;
    }

    private int reverse(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        return Integer.parseInt(sb.reverse().toString());
    }
}
