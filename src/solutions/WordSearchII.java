package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

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
                cur.map.putIfAbsent( c, new TrieNode() );
                cur = cur.map.get( c );
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

    private void dfs(List<String> result, TrieNode cur, char[][] board, int x, int y, int row, int col ) {
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
