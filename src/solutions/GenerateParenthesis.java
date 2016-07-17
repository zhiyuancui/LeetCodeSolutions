package solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	 public List<String> generateParenthesis(int n) {
	        
	        List<String> result = new ArrayList<String>();
	        if( n < 1 ){
	            return result;
	        }
	        
	        
	        //generate(result, "", n,n);
	        char[] temp = new char[n+n];
	        generate(result, n,n, temp,0);
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
	    
	    private void generate(List<String> res,int l,int r,char[] tmp,int index){  
	        if(l==0 && r==0){  
	            res.add(new String(tmp));  
	            return;  
	        }  
	        if(l>0){  
	            tmp[index]='(';  
	            generate(res,l-1,r,tmp,index+1);  
	        }  
	        if(r>0 && r>l){  
	            tmp[index]=')';  
	            generate(res,l,r-1,tmp,index+1);  
	        }  
	    }  
	
}
