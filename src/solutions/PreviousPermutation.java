package solutions;

/**
 * 1053 Previous Permutation With One Swap
 */
public class PreviousPermutation {
    public int[] prevPermOpt1(int[] arr) {
        if(arr == null || arr.length == 0) {
            return new int[0];
        }

        int i = arr.length - 2, max = -1;
        while(i >= 0 && arr[i] <= arr[i+1]) {
            i--;
        }

        if(i >= 0) {
            max = i + 1;
            for(int j = max + 1; j < arr.length; j++) {
                if(arr[max] < arr[j] && arr[j] < arr[i]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
