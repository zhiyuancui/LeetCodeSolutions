package solutions;

import java.util.*;

/**
 * 1387 Sort Integers by The Power Value
 */
public class SortIntegersByThePowerValue {
    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i = lo; i <= hi; i++) {
            list.add(i);
        }

        Collections.sort(list, (a, b) -> {
            if(getPower(a) != getPower(b)) {
                return getPower(a) - getPower(b);
            } else {
                return a - b;
            }
        });

        return list.get(k-1);
    }


    public int getPower(int x) {
        if(!map.containsKey(x)) {
            if(x == 1) {
                map.put(x, 0);
            } else if( (x&1) != 0) {
                map.put(x, getPower(x*3+1)+1);
            } else {
                map.put(x, getPower(x/2) + 1);
            }
        }

        return map.get(x);
    }
}
