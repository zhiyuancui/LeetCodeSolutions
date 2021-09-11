package solutions;

/**
 * 1891 Cutting Ribbons
 */
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int left = 1;
        int right = (int) 1e5 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (!isCutPossible(ribbons, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean isCutPossible(int[] ribbons, int target, int k) {
        int count = 0;
        for(int i = 0; i < ribbons.length; i++) {
            count += ribbons[i] / target;
        }

        return count >= k;
    }
}
