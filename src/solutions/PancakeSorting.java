package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Pancake Sorting
 * https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC%2B%2BPython-Straight-Forward
 * //1, 从后往前找
 * //2, 先找到这个位置，应该的那个数字在哪
 * //3, 把这个数字先flip到第一个去
 * //4，把这个数字再flip到它应该对应的位置
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = arr.length; i > 0; i--) {
            int index = find(arr, i);

            if(index == i - 1) {
                continue;
            }
            if(index != 0) {
                ans.add(index + 1);
                flip(arr, index + 1);
            }

            ans.add(i);
            flip(arr, i);
        }

        return ans;
    }

    private void flip(int[] arr, int k) {
        int i = 0;
        while( i < k / 2) {
            int temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
            i++;
        }
    }

    private int find(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
