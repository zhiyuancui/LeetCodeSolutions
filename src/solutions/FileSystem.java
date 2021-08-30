package solutions;

import java.util.*;

/**
 * 588 Design In-Memory File System
 */
class FileSystem {

    FileNode root = new FileNode();

    public FileSystem() {

    }


    public List<String> ls(String path) {
        FileNode cur = root;
        String[] splits = path.split("/");
        for(int i = 1; i < splits.length; i++) {
            String c = splits[i];
            if(!cur.dir.containsKey(c)) {
                return new ArrayList<>();
            }
            cur = cur.dir.get(c);
        }

        List<String> result = new ArrayList<>();
        if(cur.isFile) {
            result.add(cur.fileName);
        } else {
            for(String name : cur.dir.keySet()) {
                result.add(name);
            }
        }

        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        FileNode cur = root;
        String[] splits = path.split("/");

        for(int i = 1; i < splits.length; i++) {
            String c = splits[i];
            if(!cur.dir.containsKey(c)) {
                cur.dir.put(c, new FileNode());
            }
            cur = cur.dir.get(c);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileNode cur = root;
        String[] splits = filePath.split("/");
        for(int i = 1; i < splits.length; i++) {
            String c = splits[i];
            if(!cur.dir.containsKey(c)) {
                cur.dir.put(c, new FileNode());
            }
            cur = cur.dir.get(c);
        }

        cur.isFile = true;
        cur.content.append(content);
        cur.fileName = splits[splits.length - 1];
    }

    public String readContentFromFile(String filePath) {
        FileNode cur = root;
        String[] splits = filePath.split("/");
        for(int i = 1; i < splits.length; i++) {
            String c = splits[i];
            if(!cur.dir.containsKey(c)) {
                return "";
            }
            cur = cur.dir.get(c);
        }

        if(cur.isFile) {
            return cur.content.toString();
        } else {
            return "";
        }
    }

    class FileNode {
        boolean isFile;
        StringBuilder content;
        String fileName;
        Map<String, FileNode> dir;

        public FileNode() {
            isFile = false;
            dir = new HashMap<>();
            content = new StringBuilder();
        }
    }
}

