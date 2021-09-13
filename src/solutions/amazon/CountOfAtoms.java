package solutions.amazon;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 726 Number of Atoms
 */
public class CountOfAtoms {
    public String countOfAtoms(String formula) {
        if(formula == null || formula.length() == 0) {
            return "";
        }

        int len = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap());

        int idx = 0;

        while(idx < len) {
            if(formula.charAt(idx) == '(') {
                stack.push(new TreeMap());
                idx++;
            } else if(formula.charAt(idx) == ')') {
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> peek = stack.peek();
                int start = idx+1;
                int multiply = 1;
                idx++;// move i to next char
                while(idx < len && Character.isDigit(formula.charAt(idx))) {
                    idx++;
                }
                if(idx > start) {
                    multiply = Integer.parseInt(formula.substring(start, idx));
                }
                for(String atom : top.keySet()) {
                    int count = top.get(atom);
                    peek.put(atom, peek.getOrDefault(atom,0) + count * multiply);
                }
            } else {
                int start = idx;
                idx++;
                while (idx < len && Character.isLowerCase(formula.charAt(idx))) {
                    idx++;
                }
                String atom = formula.substring(start, idx);
                start = idx;
                while (idx < len && Character.isDigit(formula.charAt(idx))) {
                    idx++;
                }

                int times = idx > start ? Integer.parseInt(formula.substring(start, idx)): 1;

                stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + times);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String atom: stack.peek().keySet()) {
            sb.append(atom);
            int times = stack.peek().get(atom);
            if(times > 1) {
                sb.append(times);
            }
        }

        return sb.toString();

    }
}
