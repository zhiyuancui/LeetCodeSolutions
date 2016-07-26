package solutions;

public class ReverseVowels {
	public String reverseVowels(String s) {
        if( s == null || s.length() == 0 ){
            return s;
        }
        
        String vowels = "aeiouAEIOU";
        
        char[] chars = s.toCharArray();
        
        int left = 0;
        int right = s.length() - 1;
        
        while( left < right ){
            
            while( left < right && !vowels.contains( chars[left]+"") ){
                left++;
            }
            
            while( left < right && !vowels.contains( chars[right]+"") ){
                right--;
            }
            
            char temp = chars[ left ];
            chars[ left ] = chars[ right ];
            chars[ right ]= temp;
            
            left++;
            right--;
        }
        
        return new String( chars );
    }
}
