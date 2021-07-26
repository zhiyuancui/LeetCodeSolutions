package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    /**
     * 139 Word Break
     * @param s
     * @param wordDict
     * @return
     */
	public boolean wordBreak(String s, List<String> wordDict) {
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
    
    private int getMaxLength(List<String> dict ){
        int max = 0;
        for(String word : dict){
            max = Math.max(max, word.length() );
        }
        
        return max;
    }
    
    /**
     * 140 Word Break II
     * @param s
     * @param wordDict
     * @return
     */
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
            String prefix = s.substring(0,len);
            if( dict.contains(prefix) ){
                if( len == n ){
                    result.add( prefix );
                }else{
                    String suffix = s.substring(len);
                    List<String> temp = wordBreakHelper(suffix, dict, memo);
                    for(String item: temp ){
                        item = prefix +" "+ item;
                        result.add(item);
                    }
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}
