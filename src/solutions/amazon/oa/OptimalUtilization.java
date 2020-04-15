package solutions.amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class OptimalUtilization {

    public List<List<Integer>> getPairs(List<int[]> a, List<int[]> b, int target) {
            Collections.sort(a, (i, j)->i[1] - j[1]);
            Collections.sort(b, (i, j)->i[1] - j[1]);

            List<int[]> result = new ArrayList<>();
            int max = Integer.MIN_VALUE;

        int m = a.size();
        int n = b.size();

        int left = 0;
        int right = n - 1;

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();


        while( left < m && right >= 0) {
            int total = a.get(left)[1] + b.get(right)[1];
            if(total > target) {
                right--;
            } else {
                if( max <= total) {
                    if(!map.containsKey(total)) {
                        map.put(total, new ArrayList<>());
                    }
                    int index = right;
                    while(index >= 0 && b.get(index)[1] == b.get(right)[1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a.get(left)[0]);
                        list.add(b.get(right)[0]);
                        map.get(total).add(list);
                        index--;
                    }
                    max = total;
                }
                left++;
            }
        }

        //会为null如果结果不存在
        return map.get(max);
    }

    public static void main(String[] args) {
        OptimalUtilization solution = new OptimalUtilization();

        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1,8});
        a.add(new int[]{2,7});
        a.add(new int[]{3,14});
        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1,5});
        b.add(new int[]{2,10});
        b.add(new int[]{3,14});
        List<List<Integer>> result = solution.getPairs(a, b, 20);

        for(List<Integer> res: result) {
            System.out.println(res.get(0) + " : " +res.get(1));
        }
    }
}
