package solutions;

public class FriendCircles {
	 class UnionFind {
	        private int count = 0;
	        private int[] root, size;
	        
	        public UnionFind(int n) {
	            count = n;
	            root = new int[n];
	            size = new int[n];
	            for (int i = 0; i < n; i++) {
	                root[i] = i;
	                size[i] = 1;
	            }
	        }
	        
	        public int find(int p) {
		        	while (p != root[p]) {
		                root[p] = root[root[p]];    // path compression by halving
		                p = root[p];//go to root
		            }
		        	return p;
	        }
	        
	        public void union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP == rootQ) return;
	            if (size[rootQ] > size[rootP]) {
	                root[rootP] = rootQ;
	                size[rootQ] += size[rootP];
	            }
	            else {
	                root[rootQ] = rootP;
	                size[rootP] += size[rootQ];
	            }
	            count--;
	        }
	        
	        public int count() {
	            return count;
	        }
	    }
	    
	    public int findCircleNum(int[][] M) {
	        int n = M.length;
	        UnionFind uf = new UnionFind(n);
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n; j++) {
	                if (M[i][j] == 1) uf.union(i, j);
	            }
	        }
	        return uf.count();
	    }
	}
