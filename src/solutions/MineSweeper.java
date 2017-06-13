package solutions;

public class MineSweeper {
    
    private int[] dx = {0,0,1,-1,1,1,-1,-1};
    private int[] dy = {1,-1,0,0,1,-1,1,-1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int row = board.length;
        int col = board[0].length;
        
        int x = click[0];
        int y = click[1];
        
        if( board[x][y] == 'M' ){
            board[x][y] = 'X';
            return board;
        }
        
        //Count of Mines
        int count = 0;
        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if( newX < 0 || newY < 0 || newX>= row || newY >= col ){
                continue;
            }
            if( board[newX][newY] == 'M' || board[newX][newY] == 'X' ) count++;
        }
        
        //This block is a B
        if( count > 0 ){
            board[x][y]= (char)(count+'0');
            return board;
        }
        
        board[x][y] = 'B';
        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if( newX < 0 || newY < 0 || newX>= row || newY >= col ){
                continue;
            }
            if( board[newX][newY] == 'E' ) {
                int[] newClick = {newX, newY};
                updateBoard(board,newClick);
            }
            
        }
        
        
        return board;
    }
    
    
}
