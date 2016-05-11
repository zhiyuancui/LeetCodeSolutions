package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber {

	
	
	/**
	 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
	 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
	 * For example,
	 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
	 * 
	 * Reference to https://leetcode.com/discuss/73721/easiest-20ms-94%25-java-solution
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	private char[][] pairs = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
	int count = 0;
	
	public int strobogrammaticInRange(String low, String high) {
        for( int len = low.length(); len <= high.length(); len++ ){
        	dfs( low, high, new char[len],0,len-1);
        }
        
        return count;
    }
	
	public void dfs(String low, String high, char[] c, int left, int right){
		if( left > right ){
			String s = new String(c);
			if( s.length() == low.length() && s.compareTo( low ) < 0 ||
				s.length() == high.length() && s.compareTo(high) > 0 ){
				return;
			}
			count++;
			return;
		}
		
		for(char[] p : pairs){
			c[ left ] = p[0];
			c[ right ] = p[1];
			
			if( c.length != 1 && c[0] == '0' ){
				continue;
			}
			
			if( left < right || left == right && p[0] == p[1] ){
				dfs( low, high, c, left + 1, right - 1);
			}
		}
	}
	
	/**
	 * 
	 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
	 * Find all strobogrammatic numbers that are of length = n.
	 * For example,
	 * 
	 * Given n = 2, return ["11","69","88","96"].
	 * 
	 * 
	 * Reference to : https://leetcode.com/discuss/50412/ac-clean-java-solution
	 * 
	 * @param n
	 * @return
	 */
	public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
	
	private List<String> helper(int n, int m){
		if (n == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}
	    if (n == 1) {
	    	return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    }

	    List<String> list = helper(n - 2, m);

	    List<String> res = new ArrayList<String>();

	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);

	        if (n != m) res.add("0" + s + "0");

	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }

	    return res;
	}
}
