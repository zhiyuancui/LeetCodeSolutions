package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
    class Master {
        public int guess(String s) {
            return 0;
        }
    }
    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) return;

        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        for (int i = 0; i < 10; i++) {
            // 随机猜一个
            Random r = new Random();
            int idx = r.nextInt(list.size());
            String randomPick = list.get(idx);

            int match = master.guess(randomPick);

            // 获取匹配度相同的单词列表
            List<String> candidates = new ArrayList<>();
            for (String s : list) {
                if (getMatch(s, randomPick) == match)
                    candidates.add(s);
            }

            // 每次只猜匹配度相同的那些单词
            list = candidates;
        }
    }

    private int getMatch(String s, String pick) {
        if (s == null || s.length() == 0 || pick == null || pick.length() == 0) return 0;
        int match = 0;
        for (int i = 0; i < Math.min(s.length(), pick.length()); i++) {
            if (s.charAt(i) == pick.charAt(i))
                match++;
        }
        return match;
    }
}
