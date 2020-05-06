package solutions.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFolders {
    // Time: O(N * M)  N -> length of array, M -> length of longest path string.
    // This is the fastest solution on worst case.
    // Since "folder.length <= 4 * 10^4", we may add unnessesary path into trie tree
    // but clear it later. So If we do sorting on string length first
    // we can have faster solution on average time.
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (String path : folder) {
            String[] names = path.split("\\/");
            TrieNode node = root;
            boolean needToClearChildren = true;
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                if (name.isEmpty()) {
                    continue;
                }

                if (node.children.containsKey(name)) {
                    node = node.children.get(name);
                } else {
                    if (node == root || !node.children.isEmpty()) {
                        addingIntoTree(node, names, i);
                    }

                    needToClearChildren = false;
                    break;
                }
            }

            if (needToClearChildren) {
                node.children.clear();
            }
        }

        List<String> res = new ArrayList<>();
        addingIntoRes(root, new StringBuilder(), res);
        return res;
    }

    private void addingIntoTree(TrieNode node, String[] names, int start) {
        for (int i = start; i < names.length; i++) {
            TrieNode child = new TrieNode();
            node.children.put(names[i], child);
            node = child;
        }
    }

    private void addingIntoRes(TrieNode node, StringBuilder sb, List<String> res) {
        if (node.children.isEmpty()) {
            res.add(sb.toString());
            return;
        }

        int curLen = sb.length();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            addingIntoRes(entry.getValue(), sb.append("/" + entry.getKey()), res);
            sb.delete(curLen, sb.length());
        }
    }

    private class TrieNode {
        private Map<String, TrieNode> children = new HashMap<>();
    }
}
