package solutions;

import util.ListNode;

public class OddEvenList {

	public ListNode oddEvenList(ListNode head) {
       
            if( head == null || head.next == null ){
                return head;
            }
            
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = head.next;
           
            while(odd.next != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
	
	public static void main(String[] args){
		OddEvenList o  = new OddEvenList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		o.oddEvenList(head);
	}
}
