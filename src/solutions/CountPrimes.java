package solutions;

import java.util.Arrays;

public class CountPrimes {
	
	public int countPrimes(int n) {
        
        if( n < 0 ){
            return 0;
        }
        
        int count = 0;
        
        boolean[] primes = new boolean[n + 1];
        Arrays.fill( primes, true );
        
        for(int i = 2; i < n ; i++){
            if( primes[i] ){
                count++;
                for(int j = 2; i*j < n; j++){
                    if( primes[ i * j ] ){
                        primes[ i * j ] = false;
                    }
                }
            }
        }
        
        return count;
    }
}
