package solutions;

public class RangeBitWiseAnde {
	public int rangeBitwiseAnd(int m, int n) {
        return m == n ? m : m & ~((Integer.highestOneBit(m ^ n) << 1) - 1);
    }
}
