package solutions;

/**
 * 1910 Remove All Occurrences of a Substring
 * 就是暴力解呀
 */
public class RemoveAllOccurrences {
    public String removeOccurrences(String s, String part) {
        int len = part.length();

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            sb.append(c);
            int n = sb.length();
            if(n >= len && sb.substring(n-len, n).equals(part)) {
                sb.setLength(n - len);
            }
        }

        return sb.toString();
    }
}
