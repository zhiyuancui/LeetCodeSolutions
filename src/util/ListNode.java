package util;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) {
        val = x;
        next = null;
     }

     public ListNode(int _x, ListNode _next) {
         val = _x;
         next = _next;
     }
}
