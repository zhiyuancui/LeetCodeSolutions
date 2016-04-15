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
        
        printBoard( board );
        
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
                //board[x][y] = 'T';
                printBoard( board );
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
    
    public static void main(String[] args){
    	SurroundedRegions s = new SurroundedRegions();
    	char[][] board = new char[3][3];
    	Arrays.fill(board[0], 'O');
    	Arrays.fill(board[1], 'O');
    	Arrays.fill(board[2], 'O');
    	s.solve(board);
    }
}
