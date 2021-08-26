package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1042 Flower Planting With No Adjacent
 */
public class FlowerPlanting {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<paths.length;i++){
            graph.get(paths[i][0]-1).add(paths[i][1]-1);
            graph.get(paths[i][1]-1).add(paths[i][0]-1);
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            Set<Integer> color = new HashSet<Integer>(){{
                add(1);
                add(2);
                add(3);
                add(4);
            }};

            for(int j = 0;j < graph.get(i).size();j++){
                color.remove(ans[graph.get(i).get(j)]);
            }
            ans[i] = color.iterator().next();
        }

        return ans;
    }
}
