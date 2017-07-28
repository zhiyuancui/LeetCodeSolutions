package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {
	
	private class Node{
        int x;
        int y;
        public Node(int i , int j) {
            x = i;
            y = j;
        }
    }
    
    int[]dx = {0,0,-1,1};
    int[]dy = {1,-1,0,0};
    
    public void solve(char[][] board) {
        if( board == null || board.length == 0 ) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        Queue<Node> q = new LinkedList<Node>();
        
        for(int i = 0; i < row; i++) {
            if( board[i][0] == 'O' ) {
                q.offer(new Node(i,0));
            }
            if( board[i][col-1] == 'O' ) {
                q.offer(new Node(i,col-1));
            }
        }
        
        for(int i = 0; i < col; i++) {
            if( board[0][i] == 'O' ) {
                q.offer(new Node(0,i));
            }
            if( board[row-1][i] == 'O' ) {
                q.offer(new Node(row-1,i));
            }
        }
        
        while( !q.isEmpty() ) {
            Node cur = q.poll();
            board[cur.x][cur.y] = 'F';
            for(int i = 0; i < dx.length; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if( newX >= 0 && newX < row && newY >= 0 &&  newY < col && board[newX][newY] == 'O') {
                    q.offer(new Node(newX, newY));
                }
            }
        }
        
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j++) {
                if( board[i][j] == 'O' ) {
                    board[i][j] = 'X';
                } else if( board[i][j] == 'F' ) {
                    board[i][j] = 'O';
                }
            }
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
