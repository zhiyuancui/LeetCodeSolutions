package solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	 public List<String> generateParenthesis(int n) {
	        
	        List<String> result = new ArrayList<String>();
	        if( n < 1 ){
	            return result;
	        }
	        
	        
	        generate(result, "", n,n);
	        return result;
	    }
	    
	    private void generate(List<String> result, String s, int left, int right){
	        if( left == 0 && right == 0 ){
	            result.add(s);
	            return;
	        }
	        
	        if( right < left )
	        {
	            return;
	        }
	        
	        if( left < 0 || right < 0 ){
	            return;
	        }
	        
	        generate(result, s+"(",left-1, right);
	        generate(result, s+")", left, right-1);
	    }
	
}
