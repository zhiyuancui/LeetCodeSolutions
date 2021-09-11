package solutions;

import java.util.Stack;

/**
 * 1265 Print Immutable Linked List in Reverse
 */
public class PrintImmutableLinkedList {
    interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
  };

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }
}
