package solutions;

/**
 * 1228 Missing Number In Arithmetic Progression
 */
public class MissingNumberInArithmeticProgrssion {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        int difference = (arr[arr.length - 1] - arr[0]) / n;

        int expected = arr[0];

        for (int val : arr) {
            if (val != expected) return expected;
            expected += difference;
        }
        return expected;
    }

}
