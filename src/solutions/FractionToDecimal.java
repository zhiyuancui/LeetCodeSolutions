package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reference to https://leetcode.com/discuss/67344/simple-java-solution-using-hashmap-and-stringbuilder
 * @author Zhiyuan
 *
 */
public class FractionToDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
		long num = numerator;
        long deno = denominator;
        
        if( numerator == 0 ) {
            return "0";
        }
        boolean neg = false;
        if( numerator < 0 ) {
            num = -num;
            neg = !neg;
        }
        if( denominator < 0 ) {
            deno = -deno;// if use -denominator is Integer.MIN_VALUE is not right
            neg = !neg;
        }
             
        StringBuilder sb = new StringBuilder();
        if( neg ) {
            sb.append("-");
        }
        sb.append( num / deno );
        
        long remainder = num % deno;
        
        if( remainder == 0 ) {
            return sb.toString();
        }
        
        sb.append(".");
        
        List<Long> nums = new ArrayList<Long>();
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        while( !map.containsKey(remainder) && remainder != 0 ) {
            
            map.put(remainder, index);
            num = remainder * 10;
            remainder = num % deno;
            num = num / deno;            
            nums.add(num);
            index++;
        }
        
        if( remainder == 0 ) {
            for(long n : nums) {
                sb.append(n);
            }
        } else {
            int start = map.get(remainder);
            for(int i = 0; i < start; i++) {
                sb.append(nums.get(i));
            }
            sb.append("(");
            for(int i = start; i < nums.size(); i++) {
                sb.append(nums.get(i));
            }
            sb.append(")");
        }
        
        return sb.toString();
    }
}
