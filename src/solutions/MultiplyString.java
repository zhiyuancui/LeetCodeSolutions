package solutions;

/**
 * 43 Multiply Strings
 */
public class MultiplyString {

public String multiply(String num1, String num2) {

    if( num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0 ){
        return "";
    }

    int len1 = num1.length();
    int len2 = num2.length();
    int[] res = new int[ len1 + len2 ];


    for(int i = len1 - 1; i >= 0; i--) {
        int carry = 0;
        int j = 0;
        for(j = len2 - 1; j >= 0; j--) {
            int val1 = num1.charAt(i) - '0';
            int val2 = num2.charAt(j) - '0';

            int num = val1 * val2 + res[i+j+1] + carry;

            res[i+j+1] = num % 10;
            carry = num / 10;
        }

        res[i+j+1] = carry;
    }

    StringBuilder sb = new StringBuilder();

    int idx = 0;
    while(idx < res.length - 1 && res[idx] == 0) {
        idx++;
    }

    for(; idx < res.length; idx++) {
        sb.append(res[idx]);
    }

    return sb.toString();
    }
}
