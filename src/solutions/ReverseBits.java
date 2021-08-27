package solutions;

/**
 * 190 Reverse Bits
 */
public class ReverseBits {
	
	public int reverseBits(int n) {
        
        int rst = 0;
        
        for(int i = 0; i < 32; i++ )
        {
            int digit = n >> i & 1;
            rst |= digit << ( 31 - i);
        }
        
        return rst;
    }
}
