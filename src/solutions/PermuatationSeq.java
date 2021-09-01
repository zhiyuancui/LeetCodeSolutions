package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 60 Permutation Sequence
 */
public class PermuatationSeq {
	   public String getPermutation(int n, int k) {
		   final int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		   boolean[] visited = new boolean[n + 1];
		   Arrays.fill(visited, false);
		   StringBuilder permutation = new StringBuilder();
		   for (int i = n - 1; i >= 0; i--) {
			   int cnt = arr[i];
			   for (int j = 1; j <= n; j++) {
				   if (visited[j]) {
					   continue;
				   }
				   if (k > cnt) {
					   k -= cnt;
					   continue;
				   }
				   visited[j] = true;
				   permutation.append(j);
				   break;
			   }
		   }
		   return permutation.toString();
	   }
}
