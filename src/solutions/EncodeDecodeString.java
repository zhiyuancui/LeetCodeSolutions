package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * 
 * Reference to : https://leetcode.com/discuss/55020/ac-java-solution
 * 
 * @author Zhiyuan
 *
 */

public class EncodeDecodeString {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
        		sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while( i < s.length() ){
	        	int slash = s.indexOf('/',i);
	        	int size = Integer.valueOf(s.substring(i,slash));
	        	result.add( s.substring(slash+1, slash+size+1));
	        	i = slash + size + 1;
        }
        
        return result;
    }
}
