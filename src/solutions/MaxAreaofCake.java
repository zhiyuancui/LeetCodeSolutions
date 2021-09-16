package solutions;

import java.util.Arrays;

public class MaxAreaofCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int max_h = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int max_v = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; ++i)
            max_h = Math.max(max_h, horizontalCuts[i + 1] - horizontalCuts[i]);
        for (int i = 0; i < verticalCuts.length - 1; ++i)
            max_v = Math.max(max_v, verticalCuts[i + 1] - verticalCuts[i]);
        return (int)((long)max_h * max_v % 1000000007);
    }
}
