package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RangeModule {
    TreeMap<Integer, int[]> ranges = new TreeMap<>();;

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        List<Integer> keysToUpdate = findRanges(left, right);
        int minLeft = left;
        int maxRight = right;

        for(int key : keysToUpdate) {
            int[] range = ranges.remove(key);
            minLeft = Math.min(minLeft, range[0]);
            maxRight = Math.max(maxRight, range[1]);
        }

        ranges.put(minLeft, new int[] {minLeft, maxRight});
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, int[]> pair = ranges.floorEntry(right - 1);
        if(pair == null) {
            return false;
        }
        int[] range = pair.getValue();

        return range[0] <= left && range[1] >= right;
    }

    public void removeRange(int left, int right) {
        List<Integer> keysToUpdate = findRanges(left, right - 1);

        List<int[]> newRanges = new ArrayList<>();

        for(int key : keysToUpdate) {
            int[] range = ranges.remove(key);

            if(range[0] < left) {
                newRanges.add(new int[]{range[0], left});
            }
            if(range[1] > right) {
                newRanges.add(new int[]{right, range[1]});
            }
        }

        for(int[] r: newRanges) {
            ranges.put(r[0], r);
        }
    }

    private List<Integer> findRanges(int left, int right) {
        List<Integer> result = new ArrayList<>();
        Map.Entry<Integer, int[]> next = ranges.floorEntry(right);
        while(next != null && next.getValue()[1] >= left) {
            result.add(next.getKey());
            next = ranges.floorEntry(next.getKey() - 1);
        }

        return result;
    }
}
