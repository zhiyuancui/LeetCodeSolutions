package solutions;

import util.ListNode;

import java.util.Stack;

/**
 * 445 Add Two Numbers II
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if( l1 == null ) {
            return l2;
        }

        if( l2 == null ){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode cur = l1;
        while( cur != null ) {
            stack1.push( cur.val );
            cur = cur.next;
        }

        cur = l2;
        while( cur != null ) {
            stack2.push( cur.val );
            cur = cur.next;
        }

        int carry = 0;
        while( !stack1.isEmpty() || !stack2.isEmpty() ) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();

            int num = val1 + val2 + carry;
            ListNode next = dummy.next;
            dummy.next = new ListNode( num % 10 );
            dummy.next.next = next;
            carry = num / 10;
        }

        if( carry != 0 ){
            ListNode next = dummy.next;
            dummy.next = new ListNode( carry );
            dummy.next.next = next;
        }
        return dummy.next;
    }
}
