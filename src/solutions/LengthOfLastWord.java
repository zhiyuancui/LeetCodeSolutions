package solutions;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
        
        if( s== null || s.length() == 0 )
        {
            return 0;
        }
        
        String[] parts = s.split("\\s+");
        
        if( parts.length == 0 )
        {
            return 0;
        }
        
        return parts[ parts.length - 1 ].length();
    }
}
