package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import util.Interval;

/**
 * 352 Data Stream as Disjoint Intervals
 */
public class DisjointIntervals {
    /** Initialize your data structure here. */
    TreeMap<Integer, int[]> tree;
    public DisjointIntervals() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) {
            return;
        }

        Integer low = tree.lowerKey(val);
        Integer high = tree.higherKey(val);

        if(low != null && high != null && tree.get(low)[1] + 1 == val && high == val +1) {
            tree.get(low)[1] = tree.get(high)[1];
            tree.remove(high);
        } else if(low != null && tree.get(low)[1] + 1 >= val) {
            tree.get(low)[1] = Math.max(tree.get(low)[1], val);
        } else if(high != null && high == val + 1) {
            tree.put(val, new int[]{val, tree.get(high)[1]});
            tree.remove(high);
        } else {
            tree.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> result = new ArrayList<>(tree.values());

        int[][] res = new int[result.size()][2];

        for(int i = 0; i < res.length; i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}
