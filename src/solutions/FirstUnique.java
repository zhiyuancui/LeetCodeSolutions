package solutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnique {
    Map<Integer,Integer> map = new LinkedHashMap<>();

    public FirstUnique(int[] nums) {

        for(int i : nums) {
            int count = map.getOrDefault(i,0)+1;
            map.put(i, count);
        }
    }

    public int showFirstUnique() {
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public void add(int value) {
        int count = map.getOrDefault(value, 0)+1;
        map.put(value, count);
    }
}
