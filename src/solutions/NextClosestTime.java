package solutions;

import java.util.*;

/**
 * 681 Next Closest Time
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();

        char[] digits = new char[]{result[0], result[1], result[3], result[4]};

        Arrays.sort(digits);

        result[4] = findNext(result[4], (char)('9'+1), digits);

        if(result[4] > time.charAt(4)) {
            return String.valueOf(result);
        }

        result[3] = findNext(result[3], '5', digits);
        if(result[3] > time.charAt(3)) {
            return String.valueOf(result);
        }

        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
        if(result[1] > time.charAt(1)) {
            return String.valueOf(result);
        }

        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);
    }

    private char findNext(char cur, char max, char[] digits) {
        if(cur == max) {
            return digits[0];
        }

        int pos = Arrays.binarySearch(digits, cur) + 1;

        while(pos < 4 && (digits[pos] > max || digits[pos] == cur)) {
            pos++;
        }

        return pos == 4 ? digits[0] : digits[pos];
    }
}
