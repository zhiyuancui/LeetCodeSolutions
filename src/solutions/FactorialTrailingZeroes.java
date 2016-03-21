package solutions;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        int s = 0;
        while (n>4){
            s += (n/=5);
            
        }
        return s;
    }
}
