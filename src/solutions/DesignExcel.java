package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DesignExcel {

	   private final HashMap depends = new HashMap();
	    
	    private int[][] board = null;
	    private int H = 0;
	    private int W = 0;

	    public DesignExcel(int H, char W) {
	        board = new int[H][W];
	        this.H = H;
	        this.W = W;
	    }
	    
	    public void set(int r, char c, int v) {
	        board[r-1][c-'A'] = v;
	        if(depends.get((r-1)*W+(c-'A')) != null)
	            depends.remove((r-1)*W+(c-'A'));
	    }
	    
	    public int get(int r, char c) {
	        return get(r,c,new HashMap());
	        
	    }
	    
	    private int get(int r,char c, HashMap mapping){
	        if(mapping.get(r+""+c) == null){
	            int key = (r-1)*W+(c-'A');
	            if(depends.get(key) == null){
	                mapping.put(r+""+c,board[r-1][c-'A']);
	            }else{
	                int result = 0;
	                
	                 Iterator<Integer> it = ((ArrayList<Integer>)depends.get(key)).iterator();
	                 while(it.hasNext()){
	                     int item = it.next();
	                    result+=get(item/W+1,(char)('A'+item%W),mapping);
	                 }
	                mapping.put(r+""+c,result);
	            }
	        }
	        return (int)(mapping.get(r+""+c));
	    }
	    
	    public int sum(int r, char c, String[] strs) {
	        int key = (r-1)*W+(c-'A');
	        
	            depends.put(key,new ArrayList<Integer>());
	        int result = 0;
	        HashMap mapping = new HashMap();
	        for(String s : strs){
	            String[] arr = s.split(":");
	            
	            if(arr.length == 2){
	                //System.out.println(arr[0]+","+arr[1]);
	                int min = Integer.parseInt(arr[0].substring(1));
	                int max = Integer.parseInt(arr[1].substring(1));
	                //System.out.println(min+","+max);
	                for(int i = min;i<=max;i++){
	                    for(char j = arr[0].charAt(0);j<=arr[1].charAt(0);j++){
	                        ((ArrayList<Integer>)depends.get(key)).add((i-1)*W+(j-'A'));
	                        result+=get(i,j,mapping);
	                    }
	                }
	            }else{
	                ((ArrayList<Integer>)depends.get(key)).add((s.charAt(1)-'1')*W+(s.charAt(0)-'A'));
	                result+=get(s.charAt(1)-'0',s.charAt(0));
	            }
	        }
	        return result;
	    }
	}
