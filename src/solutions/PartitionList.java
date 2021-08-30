package solutions;


import util.ListNode;

/**
 * 86 Partition List
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {

		if(head == null || head.next == null) {
			return head;
		}

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);

		ListNode l = left;
		ListNode r = right;

		while(head != null) {
			if(head.val >= x) {
				r.next = head;
				r = r.next;
			} else {
				l.next = head;
				l = l.next;
			}

			head = head.next;
		}

		r.next =  null;
		l.next = right.next;

		return left.next;
	}
}
