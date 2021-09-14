package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1557 Minimum Number of Vertices to Reach All Nodes
 */
public class MinimumNumberOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        Set<Integer> endSet = new HashSet<Integer>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
