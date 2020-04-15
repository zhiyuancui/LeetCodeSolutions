package solutions.amazon.oa;

import java.util.Arrays;

/**
 * Reorder Data in Log Files
 * Time Complexity O(NlogN) where N is the total number of logs
 * Space Complexity
 */
public class ReorderData {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) {
            return new String[0];
        }

        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ",2);
            String[] split2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            } else if(isDigit1 && isDigit2) {
                return 0;
            } else {
                return isDigit1 ? 1 : -1;
            }

        });
        return logs;
    }
}
