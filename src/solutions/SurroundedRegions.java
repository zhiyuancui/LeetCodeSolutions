package solutions;

/**
 * 130 Surrounded Regions
 */
public class SurroundedRegions {

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i<n ;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }

        for(int i = 1; i<m-1 ;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'R'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    public void dfs(char[][] b , int i, int j){
        if(i<0 || i>=b.length || j<0 || j>=b[0].length || b[i][j] != 'O') return;

        b[i][j] = 'R';

        for(int d[] : dirs){
            int x = i + d[0];
            int y = j + d[1];

            dfs(b,x,y);
        }
    }
    
    /**
     * Union Find Solution
     */
    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix
    
    public void solve2(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        
        // init, every char itself is an union
        int height = board.length, width = board[0].length;
        unionSet = new int[height * width];
        hasEdgeO = new boolean[unionSet.length];
        for(int i = 0;i<unionSet.length; i++) unionSet[i] = i;
        for(int i = 0;i<hasEdgeO.length; i++){
            int x = i / width, y = i % width;
            hasEdgeO[i] = (board[x][y] == 'O' && (x==0 || x==height-1 || y==0 || y==width-1));
        }
        
        // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width, up = x - 1, right = y + 1;
            if(up >= 0 && board[x][y] == board[up][y]) union(i,i-width);
            if(right < width && board[x][y] == board[x][right]) union(i,i+1);
        }
        
        // for each char in the matrix, if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width;
            if(board[x][y] == 'O' && !hasEdgeO[findSet(i)]) 
                board[x][y] = 'X'; 
        }
    }
    
    private void union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        // if there is an union has an 'edge O',the union after merge should be marked too
        boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
        unionSet[rootX] = rootY;
        this.hasEdgeO[rootY] = hasEdgeO;
    }
    
    private int findSet(int x){
        if(unionSet[x] == x) return x;
        unionSet[x] = findSet(unionSet[x]);
        return unionSet[x];
    }
}
