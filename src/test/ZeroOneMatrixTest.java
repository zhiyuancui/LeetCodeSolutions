package test;

import org.junit.Test;

import solutions.ZeroOneMatrix;

public class ZeroOneMatrixTest {

	@Test
	public void test() {
		ZeroOneMatrix z = new ZeroOneMatrix();
		int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
		z.updateMatrix(matrix);
	}

}
