public class isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || order == null) {
            return false;
        }

        for(int i =0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            int max = Math.max(word1.length(), word2.length());

            for(int j = 0; j < max; j++) {
                char a = j < word1.length() ? word1.charAt(j) : (char)(96);
                char b = j < word2.length() ? word2.charAt(j) : (char)(96);
                if(a != b) {
                    int idx1 = order.indexOf(a);
                    int idx2 = order.indexOf(b);
                    if(idx1 > idx2) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }

        return true;
    }
}