package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 621 Task Scheduler
 */
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
	
	
	public int schedule( int[] nums, int n ) {
		if(nums == null || nums.length == 0 ) return 0;  
        if( n == 0) return nums.length;  
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();  
        int time = 0;  
        for(int i=0; i<nums.length; i++){  
            int cur = nums[i];  
            if(!hashmap.containsKey(cur)){  
                hashmap.put(cur, time+n+1);  
            } else { // contains;  
                int latest = hashmap.get(cur);  
                if(time >= latest) {  
                    hashmap.put(cur,time+n+1);  
                }else {  
                    i--;  
                }  
            }  
            time++;  
        }  
        return time;  
	}


    public int leastInterval3(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(int t : tasks) {
            frequencies[t-'A']++;
        }

        Arrays.sort(frequencies);

        int max =  frequencies[25];
        int idle = (max-1)*n;

        for(int i = 24; i >= 0 && idle > 0; i--) {
            idle -= Math.min(max - 1, frequencies[i]);
        }

        idle = Math.max(0, idle);

        return idle + tasks.length;
    }
}
