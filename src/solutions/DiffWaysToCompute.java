package solutions;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if( input == null || input.length() == 0 ){
            return result;
        }
        
        boolean pureNum = true;
        
        for(int i = 0; i < input.length(); i++){
            if( input.charAt(i) < '0' || input.charAt(i)>'9'){
                pureNum = false;
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1));
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
        
        return result;
    }
}
