package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {
	
    public static int[] dx= {0,0,1,-1};
    public static int[] dy= {1,-1,0,0};
    
    public void solve(char[][] board) {
        
        if( board == null || board.length == 0 || board[0].length == 0 )
        {
            return;
        }
        
        int row = board.length;
        int column = board[0].length;
        
        //check first row and last row
        for(int i = 0; i < column; i++)
        {
            searchRegion(0,i,board);
            searchRegion(row - 1,i,board);

        }
        
        //check first column and last column
        for(int i = 0; i < row; i++)
        {
            searchRegion(i,0,board);
            searchRegion(i,column - 1 ,board);
        }
        
        
        for(int i =0; i < row; i++ )
        {
            for(int j = 0; j < column; j++ )
            {
                switch(board[i][j])
                {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                }
            }
        }
    }
    
    private void searchRegion(int x, int y, char[][] board)
    {
        if(board[x][y] != 'O')
        {
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        Node head = new Node(x,y);
        queue.offer(head);
        while( !queue.isEmpty() )
        {
            Node next = queue.poll();
            board[next.x][next.y] = 'F';
            ArrayList<Node> nextList = expand(next, board);
            for(Node n : nextList)
            {
                queue.offer(n);
            }
        }
    }
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private ArrayList<Node> expand(Node head, char[][] board)
    {
        ArrayList<Node> nextList = new ArrayList<Node>();
        for(int i =0;i < dx.length; i++ )
        {
            int x = head.x + dx[i];
            int y = head.y + dy[i];
            if( x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O')
            {
                board[x][y] = 'T';
                nextList.add(new Node(x, y));
            }
        }
        
        return nextList;
        
    }
    
    private void printBoard(char[][] board){
    	int row = board.length;
    	int col = board[0].length;
    	
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println("///////////////////////////////////////////");
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
