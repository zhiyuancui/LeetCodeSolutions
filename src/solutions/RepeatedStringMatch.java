package solutions;

/**
 * 686 Repeated String Match
 * https://leetcode-cn.com/problems/repeated-string-match/solution/zhong-fu-die-jia-zi-fu-chuan-pi-pei-by-leetcode/
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)){
            return 1;
        }

        int min = b.length()/a.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= min+2; i++){
            sb.append(a);
            if(i>=min && sb.toString().contains(b)){
                return i;
            }
        }

        return -1;
    }
}
