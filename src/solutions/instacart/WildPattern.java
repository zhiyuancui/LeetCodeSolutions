package solutions.instacart;

public class WildPattern {

    private int foundMatch(String target, String pattern) {
        if(pattern.charAt(0) == '*') {
            return 0;
        }

        int len1 = target.length();
        int len2 = pattern.length();

        for(int i = 0; i < len1; i++) {
            if(target.charAt(i) == pattern.charAt(0)) {
                int start = i;
                int j = 0;
                for(; j < len2; j++) {
                    if(pattern.charAt(j) == '*') {
                        if(j == len2 - 1) {
                            //C*
                            return start;
                        }
                        j++;
                        for(int k = i+j; k < len1; k++) {
                            if(target.charAt(k) != pattern.charAt(j)) {
                                continue;
                            }

                            if(foundMatch(target.substring(k+1), pattern.substring(j+1)) > 0) {
                                return start;
                            }
                        }
                    } else if(target.charAt(i+j) != pattern.charAt(j)) {
                        break;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        WildPattern w = new WildPattern();
        w.foundMatch("ABCEECDD", "A*CD*D");
    }
}
