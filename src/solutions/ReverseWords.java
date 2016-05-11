package solutions;

public class ReverseWords {

	public String reverseWords(String s) {
        
		s = s.trim();
        String[] parts = s.split("\\s+");
        if(parts.length == 0 ){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length - 1; i >= 0; i--){
            sb.append( parts[i] + "");
        }
        
        return sb.toString().trim();
    }
	
	
	/**
	 * Do in one place
	 * @param s
	 * @return
	 */
public String reverseWords2(String s){
        
        s = s.trim();
        if( s == null || s.length() == 0 ){
            return "";
        }
        
		int len = s.length();
		s = reverseChar(s,0,len-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			if( s.charAt(i) == ' ' ){
			    continue;
			}else{
			    StringBuilder word = new StringBuilder();
			    word.append( s.charAt(i) );
			    while( i + 1 < len && s.charAt(i+1) != ' ' ){
			        word.append( s.charAt( i +1 ) );
			        i++;
			    }

			    sb.append(word.reverse().toString());
			    sb.append(" ");
			}
		}
		
		return sb.deleteCharAt( sb.length() - 1 ).toString();
	}
	
	
	private String reverseChar(String s, int begin, int end ){
		if( end <  begin ){
			return s;
		}
		
		char[] array = s.toCharArray();
		while( begin <= end ){
			char temp = array[begin];
			array[begin] = array[ end ];
			array[end] = temp;
			begin++;
			end--;
		}
		
		return new String( array );
	}
	
	/**
	 * Reverse Words in a String II
	 * 
	 * Reference to: https://leetcode.com/discuss/24227/my-java-solution-with-explanation
	 * 
	 * @param s
	 */
	public void reverseWords(char[] s) {
        reverseWords(s, 0, s.length - 1);
        for(int i = 0, j = 0; i <= s.length; i++){
        	if( i == s.length || s[i] == ' ' ){
        		reverseWords( s, j , i - 1);
        		j = i + 1;
        	}
        }
    }
	
	private void reverseWords(char[] s, int begin, int end){
		while( begin < end ){
			char c = s[begin];
			s[begin] = s[end];
			s[end] = c;
			begin++;
			end--;
		}
	}
}
