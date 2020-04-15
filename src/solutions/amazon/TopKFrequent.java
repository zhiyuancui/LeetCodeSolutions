package solutions.amazon;

import java.util.*;

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

	public List<String> topKFrequent(String[] words, int k) {
        if( words == null || k <= 0) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
            if(map.get(a) == map.get(b)) {
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });


        for(String word : map.keySet()) {
            queue.add(word);
            if(queue.size()>k) {
                queue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            String word = queue.poll();
            result.add(word);
        }

        Collections.reverse(result);
        return result;
    }
	
}
