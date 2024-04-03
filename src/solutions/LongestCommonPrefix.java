package solutions;

/**
 * 14 Longest Common Prefix
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
               
        if( strs == null || strs.length == 0 )
        {
            return "";
        }
        
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++)
        {
            String can = strs[i];
            int index = 0;
            while(index < prefix.length() && index < can.length() && prefix.charAt(index) == can.charAt(index) )
            {
                index++;
            }
            
            prefix = prefix.substring(0, index);
            
        }
        
        return prefix;
    }
	
}
