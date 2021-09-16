package solutions.amazon;

import java.util.PriorityQueue;

/**
 * 1167 Minimum Cost to Connect Sticks
 */
public class ConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int i=0;i<sticks.length;i++){
                queue.offer(sticks[i]);
            }
            
            int total=0;
            while(queue.size() > 1){
                int cost=queue.poll()+queue.poll();
                total+=cost;
                queue.offer(cost);
            }
        return total;
    }
}
