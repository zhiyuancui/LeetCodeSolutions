package solutions;

import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
        if( ratings == null || ratings.length == 0 ){
            return 0;
        }
        
        int[] count = new int[ratings.length];
        Arrays.fill( count, 1);
        for(int i = 1; i < ratings.length; i++){
            if( ratings[i] > ratings[i-1] ){
                count[i] = count[ i - 1 ] + 1;
            }
        }
        
        int sum = 0;
        for(int i = ratings.length - 1; i >= 1 ; i--){
            sum += count[i];
            if( ratings[i-1] > ratings[i] && count[ i - 1 ] <= count[i]){
                count[i-1] = count[i] + 1;
            }
        }
        
        sum += count[0];
        return sum;
    }
	
}
