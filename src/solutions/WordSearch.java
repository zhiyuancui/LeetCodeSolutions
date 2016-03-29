package solutions;

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
}
