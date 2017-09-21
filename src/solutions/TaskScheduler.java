package solutions;

import java.util.Arrays;

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
}
