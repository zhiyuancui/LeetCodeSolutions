package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981 Time Based Key-Value Store
 */
public class TimeMap {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeMap());
        }

        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> tree = map.get(key);
        Integer t = tree.floorKey(timestamp);

        return t != null ? tree.get(t) : "";
    }
}
