package solutions;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public boolean exist(char[][] board, String word) {
        if( board == null || word == null || board.length == 0 || board[0].length == 0 ){
            return false;
        }
        
        if( word.length() == 0 ){
            return true;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( board[i][j] == word.charAt(0) ){
                    if( search(board,row, col, i,j,0,word) ){
                        return true;
                    }
                    
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] board, int row, int col, int x, int y, int len, String word ){
        if( len == word.length()  ){
            return true;
        }
        
        if( x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt( len ) ){
            return false;
        }
        
        board[x][y] = '#';
        boolean result = false;
        for(int i = 0; i < dx.length; i++){
            result |= search(board,row, col, x + dx[i], y +dy[i], len + 1, word); 
        }
        board[x][y] = word.charAt(len);
        return result;
    }
    
    
    /**
     * Word Search II
     * https://leetcode.com/discuss/77851/java-15ms-easiest-solution-100-00%25
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = buildTrie( words );
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i,j, root, res);
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res){
        char c = board[i][j];
        if( c == '#' || p.next[c-'a'] ==  null ){
            return;
        }
        
        p = p.next[c-'a'];
        if( p.word != null ){
            res.add( p.word );
            p.word = null;
        }
        
        board[i][j] = '#';
        if(i > 0){
            dfs(board, i - 1, j ,p, res);     
        }
        if(j > 0){
            dfs(board, i, j - 1, p, res);
        } 
        if(i < board.length - 1){ 
            dfs(board, i + 1, j, p, res);
            
        } 
        if(j < board[0].length - 1){ 
            dfs(board, i, j + 1, p, res);
            
        } 
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode cur = root;
            for(char c : w.toCharArray() ){
                int i = c - 'a';
                if( cur.next[i] == null ){
                    cur.next[i] = new TrieNode();
                }
                cur = cur.next[i];
            }
            cur.word = w;
        }
        return root;
    }
    
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
