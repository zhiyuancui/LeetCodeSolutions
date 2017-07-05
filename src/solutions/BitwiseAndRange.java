package solutions;

/**
 * Reference to http://www.cnblogs.com/grandyang/p/4431646.html
 * @author Zhiyuan
 *
 */
public class BitwiseAndRange {
	public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        
        while( m != n ){
            m >>=1;
            n >>=1;
            i++;
        }
        
        return m << i;
    }
}
