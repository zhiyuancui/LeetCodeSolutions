package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import util.Point;

public class ErectFence {
	
	/**
	 * Reference to : http://blog.csdn.net/u014688145/article/details/72200018
	 * @param points
	 * @return
	 */
	public List<Point> outerTrees(Point[] points) {
        return GrahamScan(points);
    }

    private List<Point> GrahamScan(Point[] points){
        int n = points.length;
        if (n <= 2) return Arrays.asList(points);
        //排序的原因是什么
        Arrays.sort(points,new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
            }
        });

        int[] stack = new int[n+2];
        int p = 0;
        //一个O(n)的循环
        for (int i = 0; i < n; i++) {
            while (p >= 2 && cross(points[stack[p - 2]], points[i], points[stack[p - 1]]) > 0)
                p--;
            stack[p++] = i;
        }

        int inf = p + 1;
        for (int i = n -2; i >= 0; i--){
            if (equal(points[stack[p-2]], points[i])) continue;
            while (p >= inf && cross(points[stack[p-2]], points[i], points[stack[p-1]]) > 0)
                p--;
            stack[p++] = i;
        }

        int len = Math.max(p - 1, 1);
        List<Point> ret = new ArrayList<>();
        for (int i = 0; i < len; i++){
            ret.add(points[stack[i]]);
        }

        return ret;
    }

    private int cross(Point o, Point a, Point b){
        return (a.x-o.x)*(b.y-o.y) - (a.y - o.y) * (b.x - o.x);
    }

    private boolean equal(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }
}
