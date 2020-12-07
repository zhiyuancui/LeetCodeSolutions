public class isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || order == null || words.length == 0 || order.length() == 0 ) {
            return false;
        }

        int[] index = new int[26];
        for(int i =0; i < order.length(); i++) {
            index[order.charAt(i)-'a'] = i;
        }
        boolean isignore = false;
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for(int k = 0; k < Math.min(word1.length(), word2.length()); k++) {
                if(word1.charAt(k) != word2.charAt(k)) {
                    if(index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    }
                    isignore = true;
                    break;
                }
            }

            if( word1.length() > word2.length() && ! isignore) {
                return false;
            }
        }

        return true;
    }
}