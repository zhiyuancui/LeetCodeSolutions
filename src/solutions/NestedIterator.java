package solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.NestedInteger;

/**
 * 341 Flatten Nested List Iterator
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    
    Iterator<Integer> it;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        
        list = new LinkedList<Integer>();
        flatten( nestedList );
        it = list.iterator();
    }

    private void flatten(List<NestedInteger> nestedList){
        for(NestedInteger i : nestedList){
            if( i.isInteger() ){
                list.add( i.getInteger() );  
            }else{
                flatten( i.getList() );
            }
        }
    }

    @Override
    public Integer next() {
        if( it != null ){
            return it.next();
        }else{
            return 0;
        }
    }

    @Override
    public boolean hasNext() {
        if( it != null ){
            return it.hasNext();
        }else{
            return false;
        }
    }
}
