package solutions;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if( triangle == null ){
            return 0;
        }
        
        int[] dp = new int[triangle.size()];
        
        int count = 0;
        for(int i : triangle.get(triangle.size() - 1) ){
            dp[ count ] = i;
            count++;
        }
        
        for(int row = triangle.size() - 2; row >= 0 ; row--){
            
            List<Integer> level = triangle.get(row);
            for(int i = 0; i < level.size(); i++){
                dp[i] = Math.min( dp[i],dp[i+1]) + level.get(i);
            }
        }
        
        
        return dp[0];
    }
	
	public static void main(String[] args){
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> level1 = new ArrayList<Integer>();
		level1.add(6);
		input.add(level1);
		List<Integer> level2 = new ArrayList<Integer>();
		level2.add(8);
		level2.add(0);
		input.add(level2);
		List<Integer> level3 = new ArrayList<Integer>();
		level3.add(-8);
		level3.add(2);
		level3.add(9);
		input.add(level3);
		List<Integer> level4 = new ArrayList<Integer>();
		level4.add(0);
		level4.add(-4);
		level4.add(-1);
		level4.add(-2);
		input.add(level4);
		Triangle t = new Triangle();
		t.minimumTotal(input);
	}
}
