package solutions.amazon;

import util.ListNode;

public class InsertCircularList {
    public ListNode insert(ListNode head, int insertVal) {
        if(head == null) {
            ListNode newListNode = new ListNode(insertVal, null);
            newListNode.next = newListNode;
            return newListNode;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        boolean toInsert = false;

        do {
            if(prev.val <= insertVal && insertVal <= cur.val) {
                toInsert = true;
            } else if(prev.val > cur.val) {
                if(insertVal >= prev.val || insertVal <= cur.val) {
                    toInsert = true;
                }
            }

            if(toInsert) {
                prev.next = new ListNode(insertVal, cur);
                return head;
            }

            prev = cur;
            cur = cur.next;
        } while(prev!=head);

        prev.next = new ListNode(insertVal, cur);
        return head;
    }
}
