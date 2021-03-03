package solutions;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return new int[0];
        }

        int[] array = listToArray(head);
        Stack<Integer> stack = new Stack<>();
        for(int i = array.length -1; i >= 0; i--) {
            stack.push(i);
        }

        int[] res = new int[array.length];

        for(int i = res.length -1 ; i >= 0; i--) {
            res[i] = 0;
            while(!stack.isEmpty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                if(stack.peek() > i) {
                    res[i] = array[stack.peek()];
                }
            }
            stack.push(i);
        }

        return res;
    }

    private int[] listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();

        ListNode cur = head;
        while(cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
