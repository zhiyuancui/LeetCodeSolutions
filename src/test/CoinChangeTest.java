package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.CoinChange;

public class CoinChangeTest {

	@Test
	public void test() {
		CoinChange c = new CoinChange();
		int[] coins = {1,2,5};
		c.change(5, coins);
	}

}
