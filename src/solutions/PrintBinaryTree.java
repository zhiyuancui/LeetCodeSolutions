package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.TreeNode;

public class PrintBinaryTree {
	int height = 0, width = 0;
    Map<String, String> map = new HashMap<>();
    
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (root == null) return res;
        
        measure(root, 0);
        mark(root, 0, 0, width - 1);
        
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                if (map.containsKey(i + "," + j)) {
                    row.add(map.get(i + "," + j));
                }
                else {
                    row.add("");
                }
            }
            res.add(row);
        }
        
        return res;
    }
    
    private int measure(TreeNode root, int h) {
        if (root == null) return 0;
        
        height = Math.max(height, h + 1);
        
        int w = Math.max(measure(root.left, h + 1), measure(root.right, h + 1)) * 2 + 1;
        width = Math.max(width, w);
        
        return w;
    }
    
    private void mark(TreeNode root, int y, int l, int r) {
        if (root == null) return;
        
        int x = (r + l) / 2;
        map.put(y + "," + x, root.val + "");
        
        mark(root.left, y + 1, l, x - 1);
        mark(root.right, y + 1, x + 1, r);
    }
}
