package solutions.amazon;

public class MaxSumTwoNoOverlap {

    int n = A.length;
    int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
        if (i == 0) {
            prefix[i] = A[i];
            continue;
        }
        prefix[i] = prefix[i - 1] + A[i];
    }
    // initialize max sum for L length and M length subarrays respectively
    int lmax = prefix[L - 1], mmax = prefix[M - 1];
    //initialize max sum for case 1 and case 2
    int max1 = 0, max2 = 0;
    //L before M. enumerate all the M length subarray sums, while maintaining max L length subarray sum
        for (int i = L; i <= n - M; i++) {
        int mSum = prefix[i + M - 1] - prefix[i] + A[i];
        max1 = Math.max(max1, mSum + lmax);
        lmax = Math.max(lmax, prefix[i] - prefix[i - L]);
    }
    //M before L. enumerate all the L length subarray sums, while maintaining max M length subarray sum
        for (int i = M; i <= n - L; i++) {
        int lSum = prefix[i + L - 1] - prefix[i] + A[i];
        max2 = Math.max(max2, lSum + mmax);
        mmax = Math.max(mmax, prefix[i] - prefix[i - M]);
    }
        return Math.max(max1, max2);
}
