package solutions;

import java.util.Iterator;


class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
	Integer peek = null;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(peek == null) {
			peek = it.next();
		}

		return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(peek == null) {
			return it.next();
		} else {
			Integer result = peek;
			peek = null;
			return result;
		}

	}

	@Override
	public boolean hasNext() {
		return it.hasNext() || peek != null;
	}
}
