package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
	public List<Integer> countSmaller(int[] nums) {
        int len;
        List<Integer> res = new ArrayList<>();
        if (nums == null || (len = nums.length) == 0) {
            return res;
        }
        int[] tmp = new int[len];
        BST bst = new BST();
        for (int i = len - 1; i >= 0; i--) {
            tmp[i] = bst.insert(nums[i]);
        }
        
        for(int i = 0; i < tmp.length; i++){
            res.add( tmp[i] );
        }
        
        
        return res;
    }
    
    private static class BST {
        private Node root;

        private int insert(int val) {
            int smallCount = 0;
            if (root == null) {
                root = new Node(val);
                return smallCount;
            }
            Node cur = root;
            while (true) {
                if (cur.val < val) {
                    smallCount += cur.leftCount + cur.selfCount;
                    if (cur.right == null) {
                        cur.right = new Node(val);
                        return smallCount;
                    }
                    else {
                        cur = cur.right;
                    }
                }
                else if (cur.val > val) {
                    cur.leftCount++;
                    if (cur.left == null) {
                        cur.left = new Node(val);
                        return smallCount;
                    }
                    else {
                        cur = cur.left;
                    }
                }
                // equal
                else {
                    smallCount += cur.leftCount;
                    cur.selfCount++;
                    return smallCount;
                }
            }
        }
    }

    private static class Node {
        private final int val;
        private Node left;
        private Node right;
        
        // size for left sub-tree
        private int leftCount;
        // cnt for self occurances
        private int selfCount;

        private Node(int val) {
            this.val = val;
            selfCount = 1;
        }
    }

    /**************************************
     * Merge Sort Solution
     **************************************/
    int[] sortedNums;
    int[] counts;

    public List<Integer> countSmaller2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        sortedNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }

        counts = new int[nums.length];

        divideConque(nums,  0, nums.length - 1);

        List<Integer> result = new ArrayList<>();
        for(int i : counts) {
            result.add(i);
        }

        return result;
    }

    private void divideConque(int[] nums, int start, int end) {
        if(start == end) {
            return;
        }

        int mid = start + (end-start) / 2;

        divideConque(nums, start, mid);
        divideConque(nums, mid+1, end);

        for(int i = start; i <= mid; i++) {
            int val = nums[i];
            int pos = findLastSmaller(mid+1, end, val);
            counts[i] += pos - (mid+1);
        }

        Arrays.sort(sortedNums, start, end+1);

    }

    private int findLastSmaller(int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(sortedNums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start > end ? end + 1 : -1;
    }
}
