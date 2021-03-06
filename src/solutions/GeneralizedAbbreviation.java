package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Reference to :http://www.cnblogs.com/grandyang/p/5261569.html
 * Example:
 * 
 * Given word = "word", return the following list (order does not matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * Reference to : 
 * 
 * @author Zhiyuan
 *
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
