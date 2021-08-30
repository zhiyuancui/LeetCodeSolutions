package solutions;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019 Next Greater Node in Linked List
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }

        int[] result = new int[values.size()];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < result.length; i++) {
            while(!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                result[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}
