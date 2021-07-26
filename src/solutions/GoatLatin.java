package solutions;

/**
 * 824 Goat Latin
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String suffix = "a";

        for(String word : S.split("\\s+")) {
            char first  = word.charAt(0);
            if(isVowel(first)) {
                sb.append(word).append("ma");
            } else {
                String sub = word.substring(1);
                sb.append(sub).append(first).append("ma");
            }

            sb.append(suffix);
            sb.append(" ");
            suffix += "a";
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }


    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
