package solutions;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		int count = 0;
        for(int i = 0; i < 32; i++){
            int digit = num >> i & 1;
            if( digit == 1 ){
                if( count > 0 ){
                    return false;
                }
                count++;
                if( i % 2  == 1 ){
                    return false;
                }
            }
        }
        
        
        return count == 1;
    }
}
