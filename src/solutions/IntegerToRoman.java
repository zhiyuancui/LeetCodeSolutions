package solutions;

/**
 * 12 Integer to Roman
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        if( num <= 0  )
        {
            return "";
        }

        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number.length; i++) {
            while( num / number[i] > 0) {
                num -= number[i];
                sb.append(roman[i]);
            }
        }

        return sb.toString();
    }
}
