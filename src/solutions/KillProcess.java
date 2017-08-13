package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>() );
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        
        while( !q.isEmpty() ) {
            int cur = q.poll();
            result.add(cur);
            if( map.containsKey(cur) ) {
                q.addAll( map.get(cur) );
            }
        }
        
        return result;
    }
}
