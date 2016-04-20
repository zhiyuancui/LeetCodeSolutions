package test;

import org.junit.Test;

import solutions.RemoveParentheses;

public class RemoveParenthesesTest {

	@Test
	public void test() {
		RemoveParentheses r = new RemoveParentheses();
		r.removeInvalidParentheses("()())()");
	}

}
