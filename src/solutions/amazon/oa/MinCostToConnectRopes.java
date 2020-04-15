package solutions.amazon.oa;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<sticks.length;i++){
            pq.offer(sticks[i]);
        }
        int total=0;
        while(pq.size() > 1){

            int v=pq.poll()+pq.poll();
            total+=v;
            pq.offer(v);
        }
        return total;
    }
}
