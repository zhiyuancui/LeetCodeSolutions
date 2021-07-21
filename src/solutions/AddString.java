package solutions;

/**
 * 415 Add Strings
 */
public class AddString {
	 public String addStrings(String num1, String num2) {
	        if( num1 == null || num2 == null ) {
	            return "";
	        }
	        
	        int len1 = num1.length();
	        int len2 = num2.length();
	        
	        if( len1 == 0 && len2 == 0 ) {
	            return "0";
	        }
	        
	        
	        int index1 = len1 - 1;
	        int index2 = len2 - 1;
	        
	        int carry = 0;
	        StringBuilder sb = new StringBuilder();
	        while( index1 >= 0 || index2 >= 0 ) {
	            int val1 = index1 >= 0 ? num1.charAt(index1)-'0' : 0;
	            int val2 = index2 >= 0 ? num2.charAt(index2)-'0' : 0;
	            
	            int sum = val1 + val2 + carry;
	            int digit = sum % 10;
	            carry = sum / 10;
	            sb.append(digit);
	            index1--;
	            index2--;
	        }
	        
	        if( carry > 0 ) {
	            sb.append(carry);
	        }
	        
	        return sb.reverse().toString();
	    }
}
