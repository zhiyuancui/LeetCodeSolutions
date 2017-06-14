package solutions;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        
        if( s.length() == 0 ) {
            return true;
        }
       
        
        if( s.length() > t.length() ) {
            return false;
        }
        
        int indexS = 0, indexT = 0;
        
        while(indexT < t.length()){
            if( s.charAt(indexS) == t.charAt(indexT) ) {
                indexS++;
                if( indexS == s.length() ) return true;
            }
            indexT++;
        }
        
        return false;
        
    }
}
