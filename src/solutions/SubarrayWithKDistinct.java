package solutions;

public class SubarrayWithKDistinct {
    public int subarraysWithKDistinct(int[] arr, int k) {
        long[] count = new long[arr.length +1];
        long unique = 0;

        int i = 0, total = 0, good = 0;
        for(int j = 0; j < arr.length; j++) {
            if(count[arr[j]] == 0) {
                unique++;
            }
            count[arr[j]]++;
            if(unique > k) {
                count[arr[i]]--;
                i++;
                unique--;
                good = 0;
            }
            while(count[arr[i]] > 1) {
                count[arr[i]]--;
                good++;
                i++;
            }
            if(unique == k) {
                total += good + 1;
            }
        }

        return total;
    }
}
