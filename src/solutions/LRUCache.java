package solutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
      cache = new LinkedHashMap<Integer, Integer>(){

      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        if(cache.size() > capacity) {
          return true;
        }
        return false;
      }
    };
   }

    public int get(int key) {
      if(cache.containsKey(key)) {
        int value = cache.get(key);
        moveToFront(key);
        return value;
      }
      return -1;
    }

    void moveToFront(int key) {

      int val = cache.get(key);
      cache.remove(key);
      cache.put(key,val);
    }

    public void put(int key, int value) { 
      cache.put(key, value);
      moveToFront(key);
    }
}
