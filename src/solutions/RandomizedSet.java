package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	/** Initialize your data structure here. */
    List<Integer> list;
    Random random;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        random = new Random();
        map = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if( map.containsKey(val) ) {
            return false;
        } else{
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if( !map.containsKey(val) ) {
            return false;
        } else{
        
            int index = map.get(val);
            //swap with the last;
            if( index < list.size() - 1 ){
                int last = list.get( list.size() - 1 );
                list.set(index, last);
                map.put(last, index);
            }
            list.remove( list.size() - 1 );
            map.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int size = list.size();
        int r = random.nextInt(size);
        return list.get(r);
        
    }
}
