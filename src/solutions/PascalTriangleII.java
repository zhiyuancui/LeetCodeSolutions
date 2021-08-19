package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 Pascal's Triangle II
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>( rowIndex + 1);
        result.add(1);
        if( rowIndex < 1 ){
            return result;
        }

        for(int i = 0; i < rowIndex; i++){
            result.add(0);
        }
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                int num = result.get(j) + result.get( j - 1);
                result.set(j,num);
            }
        }

        return result;
    }
}
