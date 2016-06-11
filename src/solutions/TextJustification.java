package solutions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
	       int wordsCount = words.length;
	        List<String> result = new ArrayList<String>();
	        int curLen = 0;
	        int lastI = 0;
	        for (int i = 0; i <= wordsCount; i++) {
	            if (i == wordsCount || curLen + words[i].length() + i - lastI > maxWidth) {
	                StringBuffer buf = new StringBuffer();
	                int spaceCount = maxWidth - curLen;
	                int spaceSlots = i - lastI - 1;
	                if (spaceSlots == 0 || i == wordsCount) {
	                    for(int j = lastI; j < i; j++){
	                        buf.append(words[j]);
	                        if(j != i - 1)
	                            appendSpace(buf, 1);
	                    }
	                    appendSpace(buf, maxWidth - buf.length());
	                } else {
	                    int spaceEach = spaceCount / spaceSlots;
	                    int spaceExtra = spaceCount % spaceSlots;
	                    for (int j = lastI; j < i; j++) {
	                        buf.append(words[j]);
	                        if (j != i - 1)
	                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
	                    }
	                }
	                result.add(buf.toString());
	                lastI = i;
	                curLen = 0;
	            }
	            if (i < wordsCount)
	                curLen += words[i].length();
	        }
	        return result;
	    }

	    private void appendSpace(StringBuffer sb, int count) {
	        for (int i = 0; i < count; i++)
	            sb.append(' ');
	    }
}
