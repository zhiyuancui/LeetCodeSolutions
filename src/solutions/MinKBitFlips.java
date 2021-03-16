package solutions;

public class MinKBitFlips {
    public int minKBitFlips(int[] A, int K) {

        int ans = 0, len = A.length;
        for(int i = 0; i < len; i++) {
            if(A[i] == 0) {
                if(len - i < K) {
                    return -1;
                }
                flipBits(A,K, i);
                ans++;
            }
        }

        return ans;
    }

    private void flipBits(int[] A, int k, int idx) {
        for(int i = idx; i <idx+k; i++) {
            A[i] = A[i] ^ 1;
        }
    }
}
