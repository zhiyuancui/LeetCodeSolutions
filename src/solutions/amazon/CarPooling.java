package solutions.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        if(n==0) return true;
        PriorityQueue<int[]> t = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int i = 0;
        for(int[] trip:trips) {
            t.add(new int[]{trip[1],1,trip[0]});
            t.add(new int[]{trip[2],0,trip[0]});
            i++;
        }
        int currCap = capacity;
        while (!t.isEmpty()) {
            int[] curr = t.poll();
            if(curr[1]==1) {
                if(curr[2]>currCap) return false;
                currCap-=curr[2];
            } else {
                currCap+=curr[2];
            }
        }
        return true;
    }
}
