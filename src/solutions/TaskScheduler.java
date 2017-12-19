package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) {
            i--;
        }
        
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
	
	/**
	 * More easy understand way
	 * Reference to :
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval2(char[] tasks, int n) {
        int max = 0;
        int maxCount = 0;
        int[] count = new int[26];
        for(char task : tasks ) {
        		count[ task -'A']++;
        		if( max == count[task - 'A'] ) {
        			maxCount++;
        		} else if(max < count[task-'A']){
        			max = count[ task - 'A'];
        			maxCount = 1;
        		}
        }
        
        int partCount = max - 1;
        int partLen = n - (maxCount - 1);
        int emptySlots = partCount * partLen;
        int taskLeft = tasks.length - max*maxCount;
        int idles = Math.max(0, emptySlots - taskLeft);
        return tasks.length + idles;
    }
	
	private class Node{
		int val;
		int count;
		public Node( int value ) {
			val = value;
			count = 1;
		}
	}
	
	public int schedule( int[] nums, int n ) {
		Map<Integer,Integer> map = new HashMap<>();
		PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->b.val-a.val);
		
		Node[] summary = new Node[10];
		for( int each : nums ){
			if( summary[each] == null ) {
				summary[each] = new Node( each );
			} else {
				summary[each].count++;
			}
		}
		
		for( Node node : summary ) {
			if( node != null ) {
				queue.add(node);
			}
		}
		
		int time = 0;
		LinkedList<Node> temp = new LinkedList<Node>();
		while( !queue.isEmpty() || !temp.isEmpty() ){
			if( !queue.isEmpty() ){
				Node cur = queue.poll();
				if( !map.containsKey(cur.val) ) {
					map.put( cur.val , time+n+1);
					cur.count--;
					if( cur.count > 0 ) {
						temp.add(cur);
					}
					while(!temp.isEmpty()){
						queue.add( temp.poll() );
					}
					time++;
				} else {
					if( time >= map.get( cur.val ) ){
						map.put( cur.val, time+n+1);
						cur.count--;
						if( cur.count > 0 ) {
							temp.add( cur );
						}
						while(!temp.isEmpty()){
							queue.add( temp.poll() );
						}
						time++;
					} else {
						temp.add(cur);
					}
				}
			} else {
				while( !temp.isEmpty() ) {
					queue.offer( temp.poll() );
				}
				time++;
			}
		}
		
		return time;
	}
}
