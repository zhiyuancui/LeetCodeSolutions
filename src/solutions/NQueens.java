package solutions;

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
}
