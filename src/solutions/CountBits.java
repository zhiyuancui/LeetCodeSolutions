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
}
