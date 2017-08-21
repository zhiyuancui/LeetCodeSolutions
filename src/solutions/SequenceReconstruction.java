package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		if(seqs == null || seqs.size() == 0){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> pre = new HashMap<>();
        
        for(int i = 0; i < org.length; i++) {
            map.put( org[i],i);
        }
        
        for(List<Integer> seq : seqs) {
            for(int i = 0; i < seq.size(); i++) {
                if( !map.containsKey(seq.get(i)) ) return false;
                if( i > 0 && map.get(seq.get(i-1) ) >= map.get(seq.get(i))) return false;
                if( !pre.containsKey(seq.get(i)) ) {
                    int value = i > 0 ? map.get(seq.get(i-1)) : -1;
                    pre.put(seq.get(i), value);
                } else {
                    int value = i > 0 ? map.get(seq.get(i-1)) : -1;
                    pre.put(seq.get(i), Math.max(pre.get( seq.get(i) ), value) );
                }
            }
        }
        
        for(int i = 0; i < org.length; i++) {
            if( pre.get(org[i]) == null || pre.get( org[i] ) != i -1 ) {
                return false;
            }
        }
        
        return true;
    }
}
