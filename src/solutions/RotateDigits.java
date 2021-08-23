package solutions;

/**
 * 788 Rotate Digits
 */
public class RotateDigits {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++)
            if (good(i, false)) ans++;
        return ans;
    }

    // Return true if n is good.
    // The flag is true iff we have an occurrence of 2, 5, 6, 9.
    public boolean good(int n, boolean flag) {
        if (n == 0) return flag;

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) return false;
        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
        return good(n / 10, true);
    }
}
