package solutions;

public class RandomPickWithWeight {
    int[] prefixSums;
    int totalSum;

    public RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        int sum = 0;
        for(int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSums[i] = sum;
        }

        this.totalSum = sum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int low = 0, high = this.prefixSums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(target > this.prefixSums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
