package solutions;

public class IntegerReplacement {
	/**
	 * Reference to :http://blog.csdn.net/tingting256/article/details/52558884
	 * @param n
	 * @return
	 */
	public int integerReplacement(int n) {
        long N = n;
        int step = 0;
        while( N != 1 ) {
	        	if( N % 2 == 0 ) {
	        		N >>=1;
	        	} else {
	        		if( N == 3 ) {
	        			step += 2;
	        			break;
	        		}
	        		N = (N&2) == 2 ? N + 1 : N - 1;
	        	}
	        	step++;
        }
        
        return step;
    }
}
