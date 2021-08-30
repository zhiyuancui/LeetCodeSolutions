package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 Pascal's Triangle
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( numRows < 1 ){
            return result;
        }

        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(new ArrayList<Integer>( prev ) );
        int row = 1;

        while( row < numRows ){
            prev.add(0,0);
            prev.add(0);
            List<Integer> next = new ArrayList<Integer>();
            for(int i = 0; i < prev.size() - 1; i++){
                next.add( prev.get(i) + prev.get(i+1));
            }

            result.add( new ArrayList<Integer>( next ) );
            prev = next;
            row++;
        }

        return result;
    }
}
