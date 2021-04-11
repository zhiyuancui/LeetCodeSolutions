package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int curFuel = startFuel, refuelTime = 0, station = 0;

        while(true){
            //track all reachable stations' gas from current location
            while(station < stations.length && stations[station][0] <= curFuel){
                pq.offer(stations[station][1]);
                ++station;
            }
            //already enough to get to target
            if(curFuel >= target){
                return refuelTime;
            }
            //not have enough gas with all possible stations => cannot reach target
            if(pq.isEmpty()){
                return -1;
            }
            //refuel at station which is reachable and with maximum gas
            curFuel += pq.poll();
            ++refuelTime;
        }
    }
}
