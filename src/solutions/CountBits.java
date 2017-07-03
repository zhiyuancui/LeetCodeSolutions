package solutions;

public class CountBits {
	public int[] countBits(int num) {
        
        int[] result = new int[ num + 1];
        
        for(int i = 1; i <= num; i++)
        {
            int count = 0;
            for(int j = 0; j <32; j++)
            {
                if( (i >> j & 1 ) == 1 )
                {
                    count++;
                }
            }
            
            result[i] = count;
        }
        
        return result;
    }
	
	/**
	 * Reference to https://discuss.leetcode.com/topic/40162/three-line-java-solution/2
	 * f[i] = f[i/2] + i % 2;
	 * @param num
	 * @return
	 */
	public int[] countBits2(int num){
		int[] res = new int[num+1];
		
		for(int i = 1; i <= num; i++){
			System.out.println( i >> 1);
			res[i] = res[ i >> 1 ] + (i&1);
		}
		
		return res;
	}
}
