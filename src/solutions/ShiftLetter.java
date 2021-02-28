package solutions;

public class ShiftLetter {
    public String shiftingLetters(String S, int[] shifts) {
        if(S == null || S.length() == 0 || shifts == null) {
            return "";
        }

        int[] sum = new int[shifts.length];
        sum[shifts.length - 1] = shifts[shifts.length - 1] % 26;

        for(int i = shifts.length - 2; i >= 0; i--) {
            sum[i] = (shifts[i] + sum[i+1]) % 26;
        }

        char[] array = S.toCharArray();

        for(int i = 0; i < array.length; i++) {
            int shift = sum[i];
            System.out.println(array[i] + " " + shift);
            char next = shiftNext(array[i], shift);

            array[i] = next;
        }

        return new String(array);
    }

    private char shiftNext(char c, int shift) {
        int index = c - 'a';
        return (char)((index+shift) % 26 + 97);
    }
}
