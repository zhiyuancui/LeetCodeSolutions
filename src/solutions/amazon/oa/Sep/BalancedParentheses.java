package solutions.amazon.oa.Sep;

public class BalancedParentheses {
    /**
     * 0: (
     * 1: )
     * 2: [
     * 3: ]
     * 4: ?
     * @param count
     * @return
     */
    private boolean isBalanced(int[] count) {
        int numberOfUnbalanced = Math.abs(count[0] - count[1]) + Math.abs(count[2]-count[3]);

        if(count[4] - numberOfUnbalanced >= 0 && (count[4] - numberOfUnbalanced) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int checkBalanced(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;

        int[] countRight = new int[5];
        int[] countLeft = new int[5];

        //initialize right count
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            update(c, countRight, 1);
        }

        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            update(c, countLeft, 1);
            update(c, countRight, -1);

            if( isBalanced(countLeft) && isBalanced(countRight)) {
                System.out.println("cut at: " + i);
                count++;
            }
        }

        return count;
    }

    private void update(char c, int[] array, int incre) {
        switch (c) {
            case '(':
                array[0] += incre;
                break;
            case ')':
                array[1] += incre;
                break;
            case '[':
                array[2] += incre;
                break;
            case ']':
                array[3] += incre;
                break;
            case '?':
                array[4] += incre;
                break;
        }
    }

    public static void main(String[] args) {
        BalancedParentheses b = new BalancedParentheses();
        System.out.println("Expected: 1");
        System.out.println("Actual: " + b.checkBalanced("(?]["));
        System.out.println("--------------------------------------");

        System.out.println("Expected: 2");
        System.out.println("Actual: " + b.checkBalanced("[(?][??["));
        System.out.println("--------------------------------------");

        System.out.println("Expected: 0");
        System.out.println("Actual: " + b.checkBalanced("(((?"));
        System.out.println("--------------------------------------");

    }
}
