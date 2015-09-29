package solutions;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

 int prev;
 boolean peek;
 Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     if( !peek ){
         peek = true;
         prev = iter.next();
     }
     return prev;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if( peek )
	    {
	        peek = false;
	        return prev;
	    }
	    else{
	        return iter.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if( peek )
	    {
	        return true;
	    }
	    else
	    {
	        return iter.hasNext();
	    }
	}
}
