package solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * 
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * @author Zhiyuan
 *
 */


public class Vector2D implements Iterator<Integer> {

    List<Integer> list = new ArrayList<Integer>();
    Iterator<Integer> it;

    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> vec : vec2d){
            for(int num : vec){
                list.add( num );
            }
        }
        
        it = list.iterator();
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
        if( it == null ){
            return false;
        }else{
            return it.hasNext();
        }
    }
}
