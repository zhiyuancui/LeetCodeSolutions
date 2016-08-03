package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.DeleteDuplicates;
import util.ListNode;

public class DeleteDuplicatesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DeleteDuplicates d = new DeleteDuplicates();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next = new ListNode(1);
		d.deleteDuplicates2(head);
	}

}
