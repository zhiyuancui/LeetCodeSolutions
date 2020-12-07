package solutions.amazon;

public class NextGreaterNode {

    ArrayList<Integer> A = new ArrayList<>();
    while (head != null) {
        A.add(head.val);
        head = head.next;
    }
    int[] res = new int[A.size()];
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < res.length; ++i) {
        while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
            res[stack.pop()] = A.get(i);
        }
        stack.push(i);
    }
    return res;
}
