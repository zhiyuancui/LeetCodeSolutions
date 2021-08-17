package solutions;

import util.ListNode;

/**
 * 234 Palindrome Linked List
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null ){
            return true;
        }

        ListNode cur = head;
        int len = 0;
        while( cur != null ){
            len++;
            cur = cur.next;
        }

        int mid = len / 2;

        cur = head;
        ListNode newHead = null;
        for(int i = 0; i < mid; i++){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead =cur;
            cur = next;
        }

        if( len % 2 == 1 ){
            cur = cur.next;
        }

        for(int i = 0; i < mid; i++ ){
            if( newHead.val != cur.val ){
                return false;
            }
            newHead = newHead.next;
            cur = cur.next;
        }
        return true;
    }
}
