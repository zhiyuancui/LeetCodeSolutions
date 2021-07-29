package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1233 Remove Sub-folders from the Filesystem
 */
public class RemoveSubFolder {
    class TrieNode{
        Map<String, TrieNode> children = new HashMap<>();
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> removeSubfolders(String[] folder) {
        for(String path: folder) {
            insert(path);
        }

        for(TrieNode child: root.children.values()) {
            findFirstNonNull(child);
        }

        return result;
    }

    private void findFirstNonNull(TrieNode node) {
        if(node.word != null) {
            result.add(node.word);
            return;
        }

        for(TrieNode child: node.children.values()) {
            findFirstNonNull(child);
        }
    }

    private void insert(String path) {
        TrieNode cur = root;
        String[] parts = path.split("/");

        for(String part : parts) {
            if(cur.word != null) {
                return;
            }

            if(!cur.children.containsKey(part)) {
                cur.children.put(part, new TrieNode());
            }

            cur = cur.children.get(part);
        }
        cur.word = path;
    }
}
