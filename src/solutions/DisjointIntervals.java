package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import util.Interval;

public class DisjointIntervals {
	/** Initialize your data structure here. */
    TreeMap<Integer, Interval> tree;
   
    public DisjointIntervals() {
        tree = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>( tree.values() );
    }
}
