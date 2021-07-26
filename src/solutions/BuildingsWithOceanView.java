package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1762 Buildings With an Ocean View
 */
public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        if(heights == null || heights.length == 0) {
            return new int[0];
        }


        List<Integer> result = new ArrayList<>();

        int tallest = heights[heights.length - 1];
        result.add(heights.length - 1);

        for(int i = heights.length - 2; i >= 0; i--) {
            if(heights[i] > tallest) {
                result.add(i);
            }

            tallest = Math.max(tallest, heights[i]);
        }

        Collections.reverse(result);

        return result.stream().mapToInt(i->i).toArray();
    }
}
