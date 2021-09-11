package solutions;

/**
 * 679 24 Game
 */
public class GameOf24 {
    private double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        if(cards == null || cards.length == 0) {
            return false;
        }

        double[] nums = new double[cards.length];

        for(int i = 0; i < cards.length; i++) {
            nums[i] = cards[i];
        }

        return backtrack(nums, nums.length);
    }

    private boolean backtrack(double[] nums, int pos) {
        if(pos == 1) {
            return Math.abs(nums[0] - 24) < EPS;
        }

        for(int i = 0; i < pos; i++) {
            for(int j = i + 1; j < pos; j++) {
                double a = nums[i];
                double b = nums[j];

                nums[j] = nums[pos-1];
                nums[i] = a + b;
                if(backtrack(nums, pos-1)) {
                    return true;
                }

                nums[i] = a - b;
                if(backtrack(nums, pos - 1)) {
                    return true;
                }

                nums[i] = b - a;
                if(backtrack(nums, pos - 1)) {
                    return true;
                }

                nums[i] = a * b;
                if(backtrack(nums, pos - 1)) {
                    return true;
                }

                if(Math.abs(b) > EPS) {
                    nums[i] = a / b;
                    if(backtrack(nums, pos - 1)) {
                        return true;
                    }
                }

                if(Math.abs(a) > EPS) {
                    nums[i] = b / a;
                    if(backtrack(nums, pos - 1)) {
                        return true;
                    }
                }
                nums[i] = a;
                nums[j] = b;
            }
        }

        return false;
    }
}
