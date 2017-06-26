package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	int solutions;
    public int totalNQueens(int n) {
    
        solutions = 0;
        int[] visited = new int[n];
        placeQueen(0, visited, n);
        return solutions;
    }
    
    public void placeQueen(int row, int[] visited, int n)
    {
        if( row == n )
        {
            solutions++;
            return;
        }
        
        for(int i = 0; i < n; i++)
        {
            if( isValid(row, i, visited) )
            {
                visited[ row ] = i;
                placeQueen(row+1, visited, n );
            }
        }
    }
    
    public boolean isValid(int row, int column, int[] visited)
    {
        for( int i = 0; i < row; i++ )
        {
            if( visited[i] == column )
            {
                return false;
            }
            
            if( row - i == Math.abs( column - visited[i]) )
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], 
            new String[n], res);
        return res;
    }
    
    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, 
                        String[] board, List<String[]> res) {
        if (r == board.length) {
            res.add(board.clone());
        }
        else {
            for (int c = 0; c < board.length; c++) {
                int id1 = r - c + board.length, id2 = 2*board.length - r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.'); row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true; d1[id1] = true; d2[id2] = true;
                    helper(r+1, cols, d1, d2, board, res);
                    cols[c] = false; d1[id1] = false; d2[id2] = false;
                }
            }
        }
    }
}
