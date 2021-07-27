package solutions;

/**
 * 1539 Kth Missing Positive Number
 */
public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        if( k <= arr[0] - 1) {
            return k;
        }

        k -= arr[0] - 1;

        for(int i = 0; i < arr.length - 1; i++) {
            int missing = arr[i+1] - arr[i] - 1;
            if( k <= missing) {
                return arr[i] + k;
            }

            k -= missing;
        }

        return arr[arr.length - 1] + k;
    }
}
