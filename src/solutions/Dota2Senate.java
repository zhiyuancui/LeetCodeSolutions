package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
	public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
        int n = senate.length();
        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')q1.add(i);
            else q2.add(i);
        }
        while(!q1.isEmpty() && !q2.isEmpty()){
            int r_index = q1.poll(), d_index = q2.poll();
            if(r_index < d_index)q1.add(r_index + n);
            else q2.add(d_index + n);
        }
        return (q1.size() > q2.size())? "Radiant" : "Dire";
    }
}
