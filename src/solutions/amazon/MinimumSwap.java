package solutions.amazon;

public class MinimumSwap {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;

        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == 'x' && ch2 == 'y')
                xy++;
            if(ch1 == 'y' && ch2 == 'x')
                yx++;
        }

        if((xy+yx)%2==1)
            return -1;

        return (xy/2) + (xy%2) + (yx/2) + (yx%2);
    }

        public int minSwap(int[] A, int[] B) {
            // n: natural, s: swapped
            int n1 = 0, s1 = 1;
            for (int i = 1; i < A.length; ++i) {
                int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
                if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                    n2 = Math.min(n2, n1);
                    s2 = Math.min(s2, s1 + 1);
                }
                if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                    n2 = Math.min(n2, s1);
                    s2 = Math.min(s2, n1 + 1);
                }
                n1 = n2;
                s1 = s2;
            }
            return Math.min(n1, s1);
        }
}

