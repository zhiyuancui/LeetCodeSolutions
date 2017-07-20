package solutions;

public class FindIntegers {
	public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();
        
        int zero[] = new int[n];
        int one[] = new int[n];
        zero[0] = one[0] = 1;
        for (int i = 1; i < n; i++) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }
        
        int result = zero[n - 1] + one[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= one[i];
        }
        
        return result;
    }
}
