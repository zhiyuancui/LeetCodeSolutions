package solutions;

public class EliminationGame {
	public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        
        while( remaining >  1 ) {
            if( left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        
        return head;
    }
}
