package solutions;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
private final Map<String, Integer> map;
    
    public MapSum() {
        map = new HashMap<>();    
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        
        int count = 0;
        
        for (String key : map.keySet()) {
            
            String keyPrefix = prefix.length() > key.length() ? key : key.substring(0, prefix.length());
            if (keyPrefix.equals(prefix))
                count += map.getOrDefault(key, 0);
        }
        
        return count;
    }
}
