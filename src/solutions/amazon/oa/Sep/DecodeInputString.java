package solutions.amazon.oa.Sep;

public class DecodeInputString {

    public String decodeString(String input, int row) {
         int len = input.length();

         int col = (len + row - 1) / row;

        char[][] matrix = new char[row][col];

         for(int i = 0; i < input.length(); i++) {
             char c = input.charAt(i);

             int x = i / col;
             int y = i % col;
             if(c == '_') {
              matrix[x][y] = ' ';
             } else {
                 matrix[x][y] = c;
             }
         }

         StringBuilder sb = new StringBuilder();

         for(int j = 0; j < col; j++) {
             int x = 0;
             int y = j;
             while(x < row && y < col) {
                 sb.append(matrix[x][y]);
                 x++;
                 y++;
             }
         }

         return sb.toString();
    }

    public static void main(String[] args) {
        DecodeInputString d = new DecodeInputString();

        System.out.println("Expected: my name is");
        System.out.println("Actual: " + d.decodeString("mnes__ya_____mi", 3));
        System.out.println("--------------------------------------");

        System.out.println("Expected: hello word");
        System.out.println("Actual: " + d.decodeString("hlowrd_el_ol", 2));
        System.out.println("--------------------------------------");
    }
}
