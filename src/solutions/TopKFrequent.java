package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reference to https://leetcode.com/discuss/100581/java-o-n-solution-bucket-sort
 * @author Zhiyuan
 *
 */
public class TopKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[ nums.length + 1 ];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for( int n : nums ){
            if( !map.containsKey(n) ){
                map.put(n,0);
            }else{
                map.put(n, map.get(n) + 1 );
            }
        }
        
        for( int key : map.keySet() ){
            int frequency = map.get( key );
            if( bucket[ frequency ] == null ){
                bucket[frequency] = new ArrayList<Integer>();
            }
            
            bucket[ frequency ].add(key);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos-- ){
            if( bucket[pos] != null ){
                result.addAll( bucket[pos] );
            }
        }
        
        return result;
    }
}
