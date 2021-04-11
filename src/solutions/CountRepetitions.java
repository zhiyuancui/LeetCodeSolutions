package solutions;

public class CountRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1 == null || s2 == null || s2.length() * n2 > s1.length() * n1) {
            return 0;
        }

        if(s2 == "") {
            return 0;
        }

        int p2 = 0;
        int count = 0;
        int k = 0;

        while(k < n1) {
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) == s2.charAt(p2)) {
                    p2++;
                }
                if(p2 == s2.length()) {
                    p2 = 0;
                    count++;
                }
            }
            k++;
            if(p2 == 0) {
                if(n1 % 2 == 0 || n1 < 2) {
                    count *= n1 / k;
                } else {
                    count = (count * (n1-1)/k) + 1;
                }
                break;
            }
        }

        return count / n2;
    }
}
