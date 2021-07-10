package solutions;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words){
            if (isMatch(s, word)){
                count++;
            }
        }
        return count;
    }

    private boolean isMatch(String word1, String word2){
        int index1 = 0, index2 = 0;
        int size1 = word1.length(), size2 = word2.length();
        while (index1 < size1 && index2 < size2){
            if (word1.charAt(index1++) != word2.charAt(index2++))
                return false;
            int c1 = 1;
            while (index1 < size1 && word1.charAt(index1) == word1.charAt(index1-1)){
                c1++;
                index1++;
            }

            int c2 = 1;
            while (index2 < size2 && word2.charAt(index2) == word2.charAt(index2-1)){
                c2++;
                index2++;
            }

            if (c1 == c2 || c1 > c2 && c1 >= 3)
                continue;
            return false;
        }
        return index1 == size1 && index2 == size2;
    }
}
