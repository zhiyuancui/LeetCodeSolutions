package solutions;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardRow {

	public String[] findWords(String[] words) {
        if( words == null || words.length == 0 ) {
            return new String[0];
        }
        
        List<String> res = new ArrayList<String>();
        
        int[] codes = new int[3];
        codes[0] = encode("qwertyuiop");
        codes[1] = encode("asdfghjkl");
        codes[2] = encode("zxcvbnm");
        
        for(String word : words){
            int code = encode(word);
            for(int i = 0; i < codes.length; i++){
                int match = code | codes[i];
                if( match == codes[i] ){
                    res.add( word );
                    break;
                }
            }
        }        
        return res.toArray(new String[ res.size() ]);
    }
    
    
    private int encode(String s){
        int res = 0;        
        char[] arr = s.toCharArray();
        for( char c : arr ){
            int index = c - 'a';
            res |= 1 << index;
        }
        
        return res;
    }
}
