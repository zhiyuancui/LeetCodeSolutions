package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 271 Encode and Decode Strings
 */

public class EncodeDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(compile(s)).append(s);
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    private String compile(String s) {
        int len = s.length();
        char[] bytes = new char[4];

        for(int i = 3; i > -1; --i) {
            System.out.println((len >> (i*8) & 0xff));
            bytes[3-i] = (char)(len >> (i*8) & 0xff);
        }

        return new String(bytes);
    }

    private int decompile(String num) {
        int result = 0;
        for(char c : num.toCharArray()) {
            result = (result << 8) + (int)c;
        }

        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, len = s.length();

        List<String> result = new ArrayList<>();

        while(i < len) {
            int length = decompile(s.substring(i, i+4));
            i += 4;

            result.add(s.substring(i, i+length));
            i += length;
        }

        return result;
    }
}
