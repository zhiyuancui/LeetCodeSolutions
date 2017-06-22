package solutions;

public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
        
        if( num < 2 ) {
            return false;
        }
        
        int root = (int)Math.sqrt(num);
        
        int sum = 1;
        
        for(int i = 2; i <= root; i++) {
            if( num % i == 0 ) {
                sum += i;
                if( i != num /i ){
                    sum += num / i;
                }
            }
            if( sum > num ){
                return false;
            }
        }
        
        return sum == num ? true: false;
    }
}
