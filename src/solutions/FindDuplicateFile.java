package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 609 Find Duplicate File in System
 */
public class FindDuplicateFile {
	public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> duplicates = new ArrayList<>();
        Map<String, List<String>> duplicateMap = new HashMap<>();

        for(String path : paths){
            String[] fileNames = path.split(" ");
            if(fileNames != null && fileNames.length > 0){
                String dirName = fileNames[0];
                for(int i = 1; i < fileNames.length; i++){
                    String fileNameAndContent = fileNames[i];

                    String fileName = fileNameAndContent.substring(0, fileNameAndContent.indexOf('('));
                    String content = fileNameAndContent.substring(fileNameAndContent.indexOf('(') + 1);

                    duplicateMap.computeIfAbsent(content, k -> new ArrayList<>()).add(dirName + "/" + fileName);

                }
            }

        }
        duplicateMap.forEach((k, v) -> {
            if(v.size() > 1){
                duplicates.add(v);
            }
        });
        return duplicates;
    }
}
