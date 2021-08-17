package solutions.instacart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HandCard {

    private final char[] idxToSuite = new char[]{'+', '-', '='};
    private final String[] idxToValue = new String[]{"A", "B", "C"};
    private final int[] idxToCount = new int[]{1, 2, 3};

    private String idxToCard(int s, int v, int c) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.idxToSuite[s]);

        for(int i = 0; i < this.idxToCount[c]; i++) {
            sb.append(this.idxToValue[v]);
        }
        return sb.toString();
    }

    private int[] cardToIdx(char[] card) {
        int s = card[0] == '+' ? 0 : (card[0] == '-' ? 1 : 2);
        int v = card[1] == 'A' ? 0 : (card[1] == 'B' ? 1 : 2);
        int c = card.length - 2;// count值分别是1，2，3
        return new int[]{s, v, c, s * 9 + v * 3 + c};
    }

    private int calculateIdx(int i, int j) {
        return i == j ? i : 3 - i - j;
    }

    public List<List<String>> getCards(String[] cards) {
        if (cards.length < 3) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        int[] cnts = new int[27];
        for (String card : cards) {
            ++cnts[cardToIdx(card.toCharArray())[3]];
        }
        for (int t1 = 0; t1 < 27; ++t1) {
            if (cnts[t1] <= 0) {
                continue;
            }
            int s1 = t1 / 9;
            int v1 = (t1 / 3) % 3;
            int c1 = t1 % 3;

            for (int t2 = t1; t2 < 27; ++t2) {
                int s2 = t2 / 9;
                int v2 = (t2 / 3) % 3;
                int c2 = t2 % 3;

                if (t1 == t2 && cnts[t2] < 2 || t1 != t2 && cnts[t2] <= 0) {
                    continue;
                }
                int s3 = calculateIdx(s1, s2);
                int v3 = calculateIdx(v1, v2);
                int c3 = calculateIdx(c1, c2);

                int t3 = s3 * 9 + v3 * 3 + c3;

                if (t3 >= t2 && (t1 == t2 && cnts[t1] >= 3 || t1 != t2 && cnts[t3] > 0)) {
                    res.add(Arrays.asList(idxToCard(s1, v1, c1), idxToCard(s2, v2, c2), idxToCard(s3, v3, c3)));
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String []args){
        String[] cards = new String[]{"+AA", "-AA", "+AA", "-C", "-B", "+AA", "-AAA", "-A", "=AA"};
        HandCard h = new HandCard();
        System.out.println(h.getCards(cards));
    }
}
