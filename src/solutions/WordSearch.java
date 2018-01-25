package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        boolean result = search(board,row, col, x + dx[0], y +dy[0], len + 1, word) ||
                search(board,row, col, x + dx[1], y +dy[1], len + 1, word) || 
                search(board,row, col, x + dx[2], y +dy[2], len + 1, word) ||
                search(board,row, col, x + dx[3], y +dy[3], len + 1, word); 
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
    class TrieNode{
        Map<Character, TrieNode> map;
        String isWord;
        public TrieNode() {
            map = new HashMap<>();
            isWord = null;
        }
    }
    
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        if( board == null || board.length == 0 ) {
            return new ArrayList<>();
        }
        
        root = new TrieNode();
        
        for( String word : words ) {
            TrieNode cur = root;
            for( char c : word.toCharArray() ) {
                if( !cur.map.containsKey(c) ) {
                    cur.map.put( c, new TrieNode() );
                }
                cur = cur.map.get(c);
            }
            cur.isWord = word;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        List<String> result = new ArrayList<>();
        for( int i = 0; i < row; i++ ) {
            for( int j = 0; j < col; j++ ) {
                dfs( result, root, board, i, j, row, col );
            }
        }
        
        return result;
    }
    
    private void dfs( List<String> result, TrieNode cur, char[][] board, int x, int y, int row, int col ) {
        char c = board[x][y];
        if( c == '#' || !cur.map.containsKey(c) ) {
            return;
        }
        
        cur = cur.map.get(c);
        if( cur.isWord != null ) {
            result.add( cur.isWord );
            cur.isWord = null;
        }
        
        board[x][y] = '#';
        for( int i = 0; i < dx.length; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx >= 0 && nx < row && ny >= 0 && ny < col ){
                dfs( result, cur, board, nx, ny, row, col );
            }
        }    
        
        board[x][y] = c;
    }
}
