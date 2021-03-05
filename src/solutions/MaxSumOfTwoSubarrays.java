package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSumOfTwoSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;

        int[] lSumArray = new int[A.length];
        int[] mSumArray = new int[A.length];

        int lSum = 0;
        int mSum = 0;

        for(int i = 0; i < A.length; i++) {
            lSum += A[i];
            if( i == L - 1) {
                lSumArray[i] = lSum;
            } else if( i >= L) {
                lSum -= A[i-L];
                lSumArray[i] = lSum;
            }

            mSum += A[i];
            if( i == M - 1) {
                mSumArray[i] = mSum;
            } else if( i >= M) {
                mSum -= A[i-M];
                mSumArray[i] = mSum;
            }
        }

        Deque<Integer> maxStack = new ArrayDeque<>();
        for(int i = A.length -1; i >= L+M-1; i--) {
            if(maxStack.isEmpty() || maxStack.peekFirst() <= mSumArray[i]) {
                maxStack.offerFirst(mSumArray[i]);
            }
        }

        int max = 0, maxL = 0, maxM = 0;
        for(int i = L -1; i < A.length-M; i++) {
            maxL = Math.max(maxL, lSumArray[i]);
            maxM = maxStack.peekFirst();
            max = Math.max(max, maxL + maxM);
            if(mSumArray[i+M] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }

        for(int i = A.length -1; i >= L + M - 1; i--) {
            if(maxStack.isEmpty() || maxStack.peekFirst() <= lSumArray[i]) {
                maxStack.offerFirst(lSumArray[i]);
            }
        }

        maxL = 0;
        maxM = 0;
        for(int i = M -1; i < A.length - L; i++) {
            maxL = maxStack.peekFirst();
            maxM = Math.max(maxM, mSumArray[i]);
            max = Math.max(maxL + maxM, max);
            if(lSumArray[i+L] == maxStack.peekFirst()) {
                maxStack.pollFirst();
            }
        }

        return max;
    }
}
