package solutions;

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
}
