package solutions;

public class OneEditDistance {
	/**
	 * One Edit Distance
	 * 
	 * Given two strings S and T, determine if they are both one edit distance apart.
	 * 
	 * Reference to :https://leetcode.com/discuss/71071/my-clear-java-solution-with-explanation
	 * 
	 */
	public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
        	if( s.charAt(i) != t.charAt(i) ){
        		if( s.length() == t.length() ){
        			return s.substring(i+1).equals(t.substring(i+1));
        		}else if( s.length() < t.length() ){
        			return s.substring(i).equals(t.substring(i+1));
        		}else{
        			return t.substring(i).equals(s.substring(i+1));
        		}
        	}
        }
        
        return Math.abs(s.length() - t.length() ) == 1;
    }
}
