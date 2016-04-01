package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if( wordDict == null || wordDict.size() == 0 ){
            return false;
        }
        
        boolean[] canseg = new boolean[s.length() + 1];
        int max = getMaxLength( wordDict );
        
        canseg[0] = true;
        for(int i = 1; i <= s.length(); i++ ){
            canseg[i] = false;
            for(int j = 1; j <= max && j <= i; j++){
                if( !canseg[i-j] ){
                    continue;
                }
                String seg = s.substring(i - j, i);
                if( wordDict.contains( seg ) ){
                    canseg[i] = true;
                    break;
                }
            }
        }
        
        return canseg[s.length()];
    }
    
    private int getMaxLength(Set<String> dict ){
        int max = 0;
        for(String word : dict){
            max = Math.max(max, word.length() );
        }
        
        return max;
    }
    
    
    public List<String> wordBreak2(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        return wordBreakHelper(s, wordDict, map);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> memo){
        if( memo.containsKey(s) ){
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<String>();
        int n = s.length();
        if( n <= 0 ){
            return result;
        }
        
        for(int len = 1; len <= n; len++ ){
            String subfix = s.substring(0,len);
            if( dict.contains(subfix) ){
                if( len == n ){
                    result.add( subfix );
                }else{
                    String prefix = s.substring(len);
                    List<String> temp = wordBreakHelper(prefix, dict, memo);
                    for(String item: temp ){
                        item = subfix +" "+ item;
                        result.add(item);
                    }
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}
