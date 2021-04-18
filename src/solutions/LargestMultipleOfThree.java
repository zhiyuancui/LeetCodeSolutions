package solutions;

import java.util.Arrays;
import java.util.Collections;

public class LargestMultipleOfThree {

    public String largestMultipleOfThree(int[] digits) {
        if(digits == null || digits.length == 0) {
            return "";
        }

        int sum = 0;
        int remain1 = 0;
        int remain2 = 0;

        for(int i : digits) {
            sum += i;

            remain1 += i % 3 == 1 ? 1 : 0;
            remain2 += i % 3 == 2 ? 1 : 0;
        }

        if(sum == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(digits);
        if(sum % 3 == 0) {
            for(int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
        } else if(sum % 3 == 2) {
            int[] find = new int[2];
            Arrays.fill(find, -1);
            if(remain2 > 0) {
                for(int i = 0; i < digits.length; i++) {
                    if(digits[i] % 3 == 2) {
                        find[0] = i;
                        break;
                    }
                }
            } else if(remain1 > 0) {
                for(int i = 0; i < digits.length; i++) {
                    if(digits[i] % 3 == 1) {
                        if(find[0] == -1) {
                            find[0] = i;
                        } else if(find[1] == -1) {
                            find[1] = i;
                            break;
                        }
                    }
                }
            }

            if(find[0] != -1) {
                for(int i = digits.length - 1; i >= 0; i--) {
                    if(i == find[0] || i == find[1]) {
                        continue;
                    }
                    sb.append(digits[i]);
                }
            }
        } else {
            int[] find = new int[2];
            Arrays.fill(find, -1);
            if(remain1 > 0) {
                for(int i = 0; i < digits.length; i++) {
                    if(digits[i] % 3 == 1) {
                        find[0] = i;
                        break;
                    }
                }
            } else if(remain2 > 0) {
                for(int i = 0; i < digits.length; i++) {
                    if(digits[i] % 3 == 2) {
                        if(find[0] == -1) {
                            find[0] = i;
                        } else if(find[1] == -1) {
                            find[1] = i;
                            break;
                        }
                    }
                }
            }


            if(find[0] != -1) {
                for(int i = digits.length - 1; i >= 0; i--) {
                    if(i == find[0] || i == find[1]) {
                        continue;
                    }
                    sb.append(digits[i]);
                }
            }
        }

        return sb.toString();
    }
}
