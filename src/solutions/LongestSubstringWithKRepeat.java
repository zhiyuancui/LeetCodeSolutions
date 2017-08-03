package solutions;

public class LongestSubstringWithKRepeat {
	/**
	 * Reference to: https://discuss.leetcode.com/topic/57372/java-divide-and-conquer-recursion-solution
	 * @param s
	 * @param k
	 * @return
	 */
	public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }
    
    private int helper(char[] str, int start, int end,  int k){
        if(end-start<k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for(int i = start;i<end;i++){
            int idx = str[i]-'a';
            count[idx]++;
        }
    
        for(int i = 0;i<26;i++){
        	//find invalid character which count smaller than k
            if(count[i]<k&&count[i]>0){ //count[i]=0 => i+'a' does not exist in the string, skip it.
                for(int j = start;j<end;j++){
                    if(str[j]==i+'a'){
                        int left = helper(str,start,j,k);
                        int right = helper(str,j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }
}
