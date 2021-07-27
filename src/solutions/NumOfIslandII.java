package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 305 Number of Islands II
 */
public class NumOfIslandII {

    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    public List<Integer> numIslands2(int row, int col, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();

        if( row <= 0 || col <= 0 ){
            return result;
        }

        int count = 0;
        int[] roots = new int[ row * col ];
        Arrays.fill(roots, -1);

        for(int[] p : positions ){
            int root = col * p[0] + p[1];
            if(roots[root] != -1) {
                result.add(count);
                continue;
            }
            roots[ root ] = root;
            count++;

            for(int i = 0; i < dx.length; i++ ){
                int x = p[0] + dx[i];
                int y = p[1] + dy[i];

                int neighbor = col * x + y;
                if( x < 0 || x >= row || y >= col || y < 0 || roots[neighbor] == -1 ){
                    continue;
                }

                int rootNeighbor = findRoot( roots, neighbor );
                if( root != rootNeighbor ){
                    roots[ root ] = rootNeighbor;
                    root = rootNeighbor;
                    count--;
                }
            }

            result.add( count );
        }

        return result;
    }

    private int findRoot(int[] roots, int id){
        while( id != roots[id] ){
            id = roots[id];
        }
        return id;
    }
}
