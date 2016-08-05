package solutions;

public class WordDictionary {

	private class TrieNode{
		public TrieNode[] children = new TrieNode[26];
		public String word = "";
	}
	
	private TrieNode root = new TrieNode();
	
	// Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
        	char letter = word.charAt(i);
        	int index = letter - 'a';
        	if( cur.children[index] == null ){
        		cur.children[ index ] = new TrieNode();
        	}
        	
        	cur = cur.children[index];
        }
        cur.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match( word.toCharArray(),0,root);
    }
    
    
    private boolean match(char[] letters, int k, TrieNode root){
    	if( k == letters.length ){
    		return !root.word.equals("");
    	}
    	
    	if( letters[ k ] != '.' ){
    		return root.children[ letters[k] - 'a' ] != null && match(letters, k + 1, root.children[ letters[k] - 'a' ]); 
    	}else{
    		for(int i = 0; i < root.children.length; i++){
    			if( root.children[i] != null ){
    				if( match( letters, k + 1, root.children[i] ) ){
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    		
    }
}
