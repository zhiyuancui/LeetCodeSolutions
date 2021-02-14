package solutions;

import java.util.*;

public class RomanInteger {
	
	/**
	 * Roman to Integer
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
	       
	       if( s == null || s.length() == 0 )
	       {
	           return 0;
	       } 
	       
	       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	       
	       map.put('I',1);
	       map.put('V',5);
	       map.put('X',10);
	       map.put('L',50);
	       map.put('C',100);
	       map.put('D',500);
	       map.put('M',1000);
	       
	       int len = s.length();
	       
	       int result = 0;
	       
	       for(int i = 0; i < len;i++)
	       {
	    	   int val1 = map.get( s.charAt(i)   );
	           int val2 = i + 1 < len ? map.get( s.charAt(i+1) ) : 0;
	           
	           if( val1 < val2 )
	           {
	               result += val2 - val1;
	               i++;
	           }
	           else
	           {
	               result += val1;
	           }
	       }
	     
	        return result;  
	    }
	
	
	/**
	 * Integer to Roman
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		if( num <= 0  )
		{
			return "";
		}

		String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < number.length; i++) {
			while( num / number[i] > 0) {
				num -= number[i];
				sb.append(roman[i]);
			}
		}

		return sb.toString();
    }
}
