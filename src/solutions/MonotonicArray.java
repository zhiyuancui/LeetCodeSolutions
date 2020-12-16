package solutions;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }

        int delta = 0;
        for(int i = 1; i < A.length; i++) {
            if(delta == 0) {
                delta = A[i] - A[i-1];
            } else {
                if( (A[i]-A[i-1])*delta < 0 ) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isMonotonic2(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}
