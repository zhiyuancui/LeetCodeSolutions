package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 465 Optimal Account Balancing
 */
public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        if(transactions == null || transactions.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }

        int[] debt = new int[map.size()];
        int idx = 0;
        for(int value : map.values()) {
            debt[idx] = value;
            idx++;
        }

        return settle(0, debt);
    }

    private int settle(int start, int[] debt) {
        while(start < debt.length && debt[start] == 0) {
            start++;
        }

        if(start == debt.length) {
            return 0;
        }

        int steps = Integer.MAX_VALUE;

        for(int i = start + 1; i < debt.length; i++) {
            if(debt[start] * debt[i] < 0) {
                debt[i] = debt[i] + debt[start];
                steps = Math.min(steps, 1 + settle(start+1, debt));
                debt[i] = debt[i] - debt[start];
            }
        }

        return steps;
    }
}
