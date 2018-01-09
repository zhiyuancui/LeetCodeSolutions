package solutions;

public class ShortestCompletingWord {
	public String shortestCompletingWord(String licensePlate, String[] words) {
	       String target = licensePlate.toLowerCase();
	        int [] charMap = new int[26];
	        // Construct the character map
	        for(int i = 0 ; i < target.length(); i++){
	            if(Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
	        }
	        int minLength = Integer.MAX_VALUE;
	        String result = null;
	        for (int i = 0; i < words.length; i++){
	            String word = words[i].toLowerCase();
	            if(matches(word, charMap) && word.length() < minLength) {
	                minLength = word.length();
	                result  = words[i];
	            }
	        }
	        return result;
	    }
	    private boolean matches(String word, int[] charMap){
	        int [] targetMap = new int[26];
	        for(int i = 0; i < word.length(); i++){
	            if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
	        }
	        
	        for(int i = 0; i < 26; i++){
	            if(charMap[i]!=0 && targetMap[i]<charMap[i]) return false;
	        }
	        return true;
	    }
}
