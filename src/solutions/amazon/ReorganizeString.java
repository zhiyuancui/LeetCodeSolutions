package solutions.amazon;

/**
 * 767 Reorganize String
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        char[] array = s.toCharArray();

        int[] count = new int[26];

        int len = s.length();

        for(int i = 0; i < len; i++) {
            count[array[i] - 'a']++;
        }

        int max = 0;
        int maxChar = 0;
        int threshold = (len+1) >> 1;

        for(int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                maxChar = i;
                if(max > threshold) {
                    return "";
                }
            }
        }

        char[] res = new char[len];

        int index = 0;
        while(count[maxChar] > 0) {
            res[index] = (char)(maxChar+'a');
            index += 2;
            count[maxChar]--;
        }

        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                if(index >= res.length) {
                    index = 1;
                }
                res[index] = (char)(i +'a');
                index += 2;
                count[i]--;
            }
        }

        return new String(res);
    }
}
