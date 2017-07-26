package solutions;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExclusiveTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ExclusiveTime e = new ExclusiveTime();
		List<String> logs = new ArrayList<String>();
		//"0:start:0","1:start:2","1:end:5","0:end:6"
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		e.exclusiveTime(2, logs);
	}

}
