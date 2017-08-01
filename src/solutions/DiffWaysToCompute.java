package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToCompute {
	
	Map<String, List<Integer>> map = new HashMap<>();
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if( input == null || input.length() == 0 ){
            return result;
        }
        
        boolean pureNum = true;
        
        for(int i = 0; i < input.length(); i++){
            if( input.charAt(i) < '0' || input.charAt(i)>'9'){
                pureNum = false;
                String p1 = input.substring(0,i);
                String p2 = input.substring(i+1);
                List<Integer> left = map.getOrDefault(p1, diffWaysToCompute(p1) );
                List<Integer> right= map.getOrDefault(p2, diffWaysToCompute(p2) );
                
                for(int m : left){
                    for(int n : right){
                        if( input.charAt(i) == '+' ){
                            result.add(m+n);
                        }else if(input.charAt(i)=='-'){
                            result.add( m - n );
                        }else if( input.charAt(i) =='*'){
                            result.add(m*n);
                        }
                    }
                }
            }
        }
        
        if( pureNum ){
            result.add(Integer.parseInt( input ));
        }
        map.put(input, result);
        return result;
    }
}
