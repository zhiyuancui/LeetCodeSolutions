package solutions;

public class EliminationGame {
	public int lastRemaining(int n) {
        boolean fromLeftToRight = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        
        while( remaining >  1 ) {
            if( fromLeftToRight || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            fromLeftToRight = !fromLeftToRight;
        }
        
        return head;
    }
}
