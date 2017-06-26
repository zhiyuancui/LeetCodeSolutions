package solutions;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	List<String> result;
    public List<String> addOperators(String num, int target) {
         result = new ArrayList<String>();
        
        if( num == null || num.length() == 0  ){
            return result;    
        }
        
        for(int i = 1; i <= num.length(); i++){
            if( i >= 2 && num.charAt(0) == '0' ){
                continue;
            }
            bfs(num.substring(i),num.substring(0,i),target,0,Long.parseLong(num.substring(0,i)),true);
        }
        
        return result;
    }
    
    public void bfs(String s, String trace, int target, long pre, long current, boolean sign){
        
        
        long sum = sign ? pre+current : pre-current;
        if( s.length() == 0 ){
            if( sum == (long) target ){
                result.add( trace );
            }
            return;
        }
        
        for(int i = 1; i <= s.length(); i++){
            if( i >= 2 && s.charAt(0) == '0' ){
                continue;
            }
            int number = Integer.parseInt( s.substring(0,i) );
            bfs( s.substring(i), trace+"+"+number, target,sum, number, true);
            bfs( s.substring(i), trace+"-"+number, target,sum, number, false);
            bfs( s.substring(i), trace+"*"+number, target,pre, current * number, sign);
        }
    }
    
}
