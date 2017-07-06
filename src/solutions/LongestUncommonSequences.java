package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUncommonSequences {

	public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
	
	/**
	 * Reference to: https://discuss.leetcode.com/topic/85027/java-hashing-solution
	 * Longest Uncommon Sequences II
	 * @param strs
	 * @return
	 */
	public int findLUSlength2(String[] strs) {
        Map<String, Integer> subseqFreq = new HashMap<>();
        for (String s : strs) 
            for (String subSeq : getSubseqs(s))
                subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
        int longest = -1;
        for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
            if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
        return longest;
    }
    
    public Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes) res.add(s.charAt(0) + seq);
        return res;
    }
}
