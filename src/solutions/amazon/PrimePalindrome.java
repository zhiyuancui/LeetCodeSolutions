package solutions.amazon;

public class PrimePalindrome {
    public int primePalindrome(int N) {
        while (true) {

            if(N%2==0 && N>2){
                ++ N;
            }

            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            // all 8 digit palindromes are not prime
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }
}

