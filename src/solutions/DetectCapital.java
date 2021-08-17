package solutions;

public class DetectCapital {

	public boolean detectCapitalUse(String word) {
        
        if( word == null || word.length() == 0 ) {
            return false;
        }
        
        int len = word.length();
        
        char[] array = word.toCharArray();
        
        int count = 0;
        boolean firstIndex = false;
        
        for( int i = 0; i < array.length; i++) {
            if( array[i] >= 'A' && array[i] <= 'Z' ) {
                count++;
                if( i == 0 ) {
                    firstIndex = true;
                }
            }    
        }
        
        if( count == 0 || count == len ) {
            return true;
        } else return count == 1 && firstIndex;
    }
}
