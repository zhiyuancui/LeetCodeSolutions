package solutions;

public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000000007;

        long min = 1;
        long max = Long.MAX_VALUE;

        long result = 0;

        int lcm = lcm(a, b);

        while(min <= max) {
            long mid = min + (max- min) / 2;
            if(totalNumber(mid, a, b, lcm) < n) {
                min = mid + 1;
            } else {
                result = mid;
                max = mid - 1;
            }
        }

        return (int)(result % mod);
    }


    private long totalNumber(long num, int a, int b, int lcm) {
        return num/a + num/b - num/lcm;
    }

    //公倍数
    private int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    //公约数
    private int gcd(int a, int b) {
        if(b == 0 ) {
            return a;
        }

        return gcd(b, a%b);
    }
}
