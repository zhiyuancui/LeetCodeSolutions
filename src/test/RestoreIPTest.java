package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.RestoreIP;

public class RestoreIPTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RestoreIP ip = new RestoreIP();
		ip.restoreIpAddresses("0000");
	}

}
