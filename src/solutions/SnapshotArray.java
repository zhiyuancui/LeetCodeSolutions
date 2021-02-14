package solutions;

import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> snaps = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    int count = 0;
    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        cache.put(index, val);
    }

    public int snap() {
        //clone cache
        Map<Integer,Integer> clone = new HashMap<>();
        for(int key: cache.keySet()) {
            clone.put(key, cache.get(key));
        }
        snaps.put(count, clone);
        count++;
        return count - 1;
    }

    public int get(int index, int snap_id) {
        Map<Integer, Integer> history = snaps.get(snap_id);
        for(int key: history.keySet()) {
            if(key == index) {
                return history.get(key);
            }
        }
        return 0;
    }
}
