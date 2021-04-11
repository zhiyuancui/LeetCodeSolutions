package solutions;

public class SuperPalindrome {
    public int superpalindromesInRange(String l, String r) {
        if(l == null || r == null) {
            return 0;
        }

        int res = 0;
        long left = Long.parseLong(l);
        long right = Long.parseLong(r);

        long end   = (long)(Math.sqrt(right));

        for(long i = 1; i <= end; i++) {
            String cur = Long.toString(i);

            String pair[] = getPalindrome(cur);
            long small = Long.parseLong(pair[0]);
            small = small * small;

            long big = Long.parseLong(pair[1]);
            big = big * big;

            if(small > right) {
                break;
            }
            if(small <= right && small >= left && isPalindrome(small)) {
                res++;
            }
            if(big <= right && big >= left && isPalindrome(big)) {
                res++;
            }
        }

        return res;

    }

    public String[] getPalindrome(String s) {
        String[] res = new String[2];

        StringBuilder sb = new StringBuilder(s);

        res[1] = s + sb.reverse().toString();
        sb = new StringBuilder(s.substring(0, s.length()-1));
        res[0] = s + sb.reverse().toString();

        return res;
    }

    private boolean isPalindrome(long num) {
        String n = Long.toString(num);
        char[] array = n.toCharArray();

        int left = 0;
        int right = array.length - 1;

        while(left <= right) {
            if(array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
