package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    Stack<Integer> stack = new Stack<>();
    List<Integer> prices = new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int len = 0;
        int max = 0;
        prices.add(price);
        for(int i = prices.size()-1; i >= 0; i--) {
            if(prices.get(i) > price) {
                return max;
            } else {
                len++;
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
