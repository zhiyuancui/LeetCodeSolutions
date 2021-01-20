package solutions;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int max = -1;
        long sum = 0;
        for(int i : piles) {
            sum += i;
            max = Math.max(max, i);
        }

        int left = sum / H == 0 ? 1 : (int)(sum/H);
        int right = max;

        while(left < right) {
            int middle = (left+right) / 2;
            if(!possible(piles, H, middle)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for(int p : piles) {
            time += (p-1) / K + 1;
        }

        return time <= H;
    }

}
