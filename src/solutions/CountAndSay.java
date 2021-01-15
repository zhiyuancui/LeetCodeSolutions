package solutions;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }

        String prev = "1";
        for(int i = 2; i <= n; i++) {
            int count = 0;
            char p = prev.charAt(0);
            StringBuilder sb = new StringBuilder();
            //System.out.println(i+":" +prev);
            for(char c : prev.toCharArray()) {
                if(c == p) {
                    count++;
                } else {
                    sb.append(count).append(p);
                    p = c;
                    count = 1;
                }
            }
            sb.append(count).append(p);
            prev = sb.toString();
        }

        return prev;
    }
}
