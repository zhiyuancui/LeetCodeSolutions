package solutions;

/**
 * 1790 Check if One String Swap Can Make Strings Equal
 */
public class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        if(s1.length() != s2.length()) {
            return false;
        }


        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        int p1 = -1;
        int p2 = -1;

        for(int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]) {
                if(p1 == -1) {
                    p1 = i;
                } else if(p2 == -1) {
                    p2 = i;
                } else {
                    return false;
                }
            }
        }

        if(p1 != -1 && p2 != -1) {
            char c = array2[p1];
            array2[p1] = array2[p2];
            array2[p2] = c;

            return s1.equals(new String(array2));
        } else {
            return false;
        }
    }
}
