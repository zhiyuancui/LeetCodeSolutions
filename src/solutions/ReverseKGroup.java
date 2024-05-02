package solutions;

import util.ListNode;

/**
 * 25 Reverse Nodes in K-Group
 */
public class ReverseKGroup {

public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = head;

        while(end != null) {
            for(int i = 1; i < k; i++) {
                end = end.next;
                if(end == null) {
                    break;
                }
            }

            if(end == null) {
                break;
            }

            prev = reverse(prev, end);
            end = prev.next;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode prev, ListNode end) {
        ListNode last = end.next;
        ListNode tail = prev.next;
        ListNode cur = tail.next;

        while(cur != last) {
            tail.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = tail.next;
        }
        return tail;
    }
}
