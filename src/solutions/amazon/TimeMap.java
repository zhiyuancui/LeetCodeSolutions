package solutions.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    class Tmp {
        Tmp(int time, String value) {
            this.time = time;
            this.value = value;
        }

        int time;
        String value;
    }

    private Map<String, List<Tmp>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Tmp(timestamp, value));
        } else {
            List<Tmp> l = new ArrayList<>();
            l.add(new Tmp(timestamp, value));
            map.put(key, l);
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            return bs(map.get(key), 0, map.get(key).size() - 1, timestamp);
        }

        return "";
    }

    String bs(List<Tmp> arr, int l, int r, int search) {

        if (l <= r) {
            int mid = l + (r - l) / 2;

            Tmp current = arr.get(mid);

            if (current.time == search
                    || (current.time < search && mid+1 <= arr.size()-1 && arr.get(mid+1).time > search)
                    || (current.time < search && mid+1 > arr.size()-1)
            ) {
                return current.value;
            } else if (search < current.time) {
                return bs(arr, l, mid-1, search);
            } else if (search > current.time) {
                return bs(arr, mid+1, r, search);
            }
        }

        return "";
    }
}
