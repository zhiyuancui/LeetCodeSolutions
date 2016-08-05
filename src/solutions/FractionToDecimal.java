package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Reference to https://leetcode.com/discuss/67344/simple-java-solution-using-hashmap-and-stringbuilder
 * @author Zhiyuan
 *
 */
public class FractionToDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
		long n=numerator;
	    long d=denominator;
	    if(n==0)return "0";
	    boolean sign= false ;
	    if(numerator<0){
	    	sign=!sign;
	    	n=-n;
	    }
	    if(denominator<0){
	    	sign=!sign;
	    	d=-d;
	    }   

	    StringBuilder sb=new StringBuilder();
	    if( sign ) {
	    	sb.append("-");
	    }
	    sb.append(n/d);
	    n%=d;
	    if( n == 0 ){
	    	return sb.toString();
	    }
	    sb.append(".");

	    HashMap<Long,Integer>map=new HashMap<Long,Integer>();
	    List<Long>list=new ArrayList<Long>();
	    
	    int index=0;
	    while( n != 0 && !map.containsKey(n)){
	        map.put(n,index);
	        index++;
	        n *= 10;
	        list.add(n/d);
	        n %= d;
	    }
	    //Divide process finished
	    if(n==0){ //No repeat
	        for(int i=0;i<list.size();i++){
	            sb.append(list.get(i));
	        }
	    }else{ //Has repeat
	        int startIndex=map.get(n);    
	        for(int i=0;i<startIndex;i++){
	            sb.append(list.get(i));
	        }
	        sb.append("(");
	        for(int i=startIndex;i<list.size();i++){
	            sb.append(list.get(i));
	        }
	        sb.append(")");
	    }
	    
	    return sb.toString();
    }
}
