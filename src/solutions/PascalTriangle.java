package solutions;

import java.util.ArrayList;
import java.util.List;

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
            
            result.add( new ArrayList<Integer>( prev ) );
            prev = next;
            row++;
        }
        
        return result;
    }
	
	/**
	 * Pascal's Triangle II
	 * @param rowIndex
	 * @return
	 */
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
