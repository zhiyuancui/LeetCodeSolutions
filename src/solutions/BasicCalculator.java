package solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator {

	private boolean isDigit(Character c) {
		return c >= '0' && c <= '9';
	}

	/**
	 * 227 Basic Calculator II
	 *
	 * @param s
	 * @return
	 */
	public int calculate2(String s) {

		if (s == null) {
			return 0;
		}


		int length = s.length();

		int res = 0;
		long preVal = 0;
		char sign = '+';
		int i = 0;

		while (i < length) {
			long curVal = 0;
			while (i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				curVal = curVal * 10 + (s.charAt(i) - '0');
				i++;
			}

			if (sign == '+') {
				res += preVal;
				preVal = curVal;
			} else if (sign == '-') {
				res += preVal;
				preVal = -curVal;
			} else if (sign == '*') {
				preVal = preVal * curVal;
			} else if (sign == '/') {
				preVal = preVal / curVal;
			}

			if (i < length) {
				sign = s.charAt(i);
				i++;
			}

		}

		res += preVal;
		return res;
	}


	/**
	 * Basic Calculator
	 */
	public int calculate3(String s) {
		int len = s.length();
		int sign = 1;
		int result = 0;

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}

				result += sum * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;
	}

	/**
	 * Basic Calculator III
	 *
	 * @param s
	 * @return
	 */

	public int calculate4(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// initialize operator
		char sign = '+';
		Stack<Long> stack1 = new Stack<>(); // store digit and '('
		Stack<Character> stack2 = new Stack<>(); // store sign before '('
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				long num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i++) - '0';
				}
				i--;
				stack1.push(eval(sign, stack1, num));
			} else if (ch == ' ') {
				continue;
			} else if (ch == '(') {
				stack1.push(Long.MAX_VALUE);
				stack2.push(sign);
				sign = '+';
			} else if (ch == ')') {
				long num = 0;
				while (stack1.peek() != Long.MAX_VALUE) {
					num += stack1.pop();
				}
				stack1.pop(); // pop out '(' (Long.MAX_VALUE)
				char operator = stack2.pop();
				stack1.push(eval(operator, stack1, num));
			} else {
				sign = ch;
			}
		}
		// what we need to do is just sum up all num in stack
		int result = 0;
		while (!stack1.isEmpty()) {
			result += stack1.pop();
		}
		return result;
	}

	private long eval(char sign, Stack<Long> stack1, long num) {
		if (sign == '+') {
			return num;
		} else if (sign == '-') {
			return -num;
		} else if (sign == '*') {
			return stack1.pop() * num;
		} else {
			return stack1.pop() / num;
		}
	}
}
	    

