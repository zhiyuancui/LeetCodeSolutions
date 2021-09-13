package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 320 Generalized Abbreviation
 */
public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
    
    /**
     * Second Solution
     * @param word
     * @return
     */
    public List<String> generateAbbreviations2(String word) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < Math.pow(2, word.length()); i++){
			StringBuilder out = new StringBuilder();
			int count = 0;
			int code = i;
			for(int j = 0; j < word.length(); j++) {
				if( (code & 1 )== 1 ) {
					count++;
					if( j == word.length() - 1 ) out.append(count);
				} else {
					if( count != 0 ) {
						out.append(count);
						count = 0;
					}
					out.append(word.charAt(j));
				}
				code >>= 1;
			}
			result.add( out.toString());
		}

        return result;
    }

}
