package solutions;

/**
 * 351 Android Unlock Patterns
 */
public class UnlockPatterns {
	
	private int count = 0;
	public int numberOfPatterns(int m, int n) {
        boolean[][] keyboard = new boolean[3][3];
        
        
        
        for(int p = m; p <= n; p++){
        	for(int i = 0; i < 3; i++){
        		for(int j = 0; j < 3; j++){
        			keyboard[i][j] = true;
        			dfs(keyboard,p-1,i,j);
        			keyboard[i][j] = false;
        		}
        	}
        }
        
        return count;
    }
	
	private void dfs(boolean[][] keyboard, int len, int x, int y ){
		if( len == 0 ){
			count++;
			return;
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j <3; j++){
				if( keyboard[i][j] ||
						( x == i && Math.abs(y-j) > 1 && !keyboard[x][1]) || //heng xiang kua le yi ge dian
						( y == j && Math.abs(x-i) > 1 && !keyboard[1][y]) || // cong xiang kua le yi ge dian
						( (x + y == i + j) && Math.abs(x-i) > 1 && !keyboard[1][1]) || // dui jiao xian kua dian
						( (x - y == i - j) && Math.abs(x-i) > 1 && !keyboard[1][1]) || // fan dui jiao xian kua dian
						(( x ==i && y == j))
						){
					continue;
				}else{
					keyboard[i][j] = true;
					dfs(keyboard,len-1,i,j);
					keyboard[i][j] = false;
				}
			}
		}
	}
}
