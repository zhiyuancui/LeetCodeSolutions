package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcatenationString {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        
        int m = words.length, n = words[0].length();
        
        for(int i = 0; i < m; i++){
            if( !toFind.containsKey( words[i] ) ){
                toFind.put( words[i], 1);
            }else{
                toFind.put(words[i], toFind.get(words[i]) + 1 );
            }
        }
        
        
        for(int right = 0; right <= s.length() - n*m; right++){
            found.clear();
            int left = 0;
            for(left = 0; left < m; left++){
                int k = right + left * n;
                String stub = s.substring(k, k +n);
                if( !toFind.containsKey( stub ) ){
                    break;
                }
                if( !found.containsKey( stub ) ){
                    found.put(stub, 1);
                }else{
                    found.put( stub, found.get( stub ) + 1);
                }
                
                if( found.get( stub ) > toFind.get( stub ) ){
                    break;
                }
            }
            if( left == m ){
                result.add( right );
            }
        }
    
        return result;
        
    }
}
