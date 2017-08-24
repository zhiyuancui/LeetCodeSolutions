package solutions;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixel {
	/**
	 * Lonely Pixel I
	 * @param picture
	 * @return
	 */
	public int findLonelyPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;
    
    int[] rowCount = new int[n], colCount = new int[m];
    for (int i=0;i<n;i++) 
        for (int j=0;j<m;j++) 
            if (picture[i][j] == 'B') { rowCount[i]++; colCount[j]++; }

    int count = 0;
    for (int i=0;i<n;i++) 
        for (int j=0;j<m;j++) 
            if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;
                
    return count;
    }
	
	
	/**
	 * Lonely Pixel II
	 * @param picture
	 * @param N
	 * @return
	 */
	public int findBlackPixel(char[][] picture, int N) {
        int row = picture.length;
        if (row == 0) return 0;
        int col = picture[0].length;
        if (col == 0) return 0;
        
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[col];
        
        for (int i = 0; i < row; i++) {
            String key = scanRow(picture, i, N, colCount);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < col; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
    
    private String scanRow(char[][] picture, int row, int target, int[] colCount) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        
        if (rowCount == target) return sb.toString();
        return "";
    }
}
