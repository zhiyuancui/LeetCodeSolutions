package solutions;

public class StrStr {
	public int strStr(String haystack, String needle) {
        if( needle == null || haystack == null){
            return -1;
        }
        
        for(int i = 0; i < haystack.length() - needle.length() + 1 ; i++){
            int j = 0;
            for(j = 0; j < needle.length(); j++){
                if( haystack.charAt(i+j) != needle.charAt(j) ){
                    break;
                }
            }
            
            if( j == needle.length() ){
                return i;
            }
        }
        
        
        return -1;
    }
	
	/**
	 * KMP
	 * Referenece to : https://leetcode.com/discuss/42202/java-kmp-solution-if-you-interested
	 */
	public int strStr2(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(haystack.length()==0)
            return -1;

        int[] pattan = prefix_function(needle);
        int start=0,i=0,j=0;
        while(i != haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;
            }else{
                if(j==0){
                    start++;i++;
                }else{
                    start = start+j-pattan[j-1];
                    i=start+pattan[j-1];
                    j=pattan[j-1];
                }

            }
            if(j==needle.length())
                return start;
        }
        return -1;
    }

    private int[] prefix_function(String needle){
        int[] pattan = new int[needle.length()];

        for(int i=1;i<pattan.length;i++){
            if(needle.charAt(i) == needle.charAt(pattan[i-1]))
                pattan[i] = pattan[i-1]+1;
        }
        return pattan;
    }
}
