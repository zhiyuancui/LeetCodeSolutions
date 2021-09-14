package solutions;

public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || V < 0 || K < 0) {
            return new int[0];
        }

        for (int i = 0; i < V; i++) {
            int cur = K;
            while (cur > 0 && heights[cur] >= heights[cur - 1]) {
                cur--;
            }

            while (cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
                cur++;
            }
            while (cur > K && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            heights[cur]++;

        }

        return heights;
    }
}
