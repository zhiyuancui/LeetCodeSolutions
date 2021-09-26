package solutions.robinhood;

import java.util.*;

public class MarginCall {

    HashMap<String, Integer> account;
    HashMap<String, Integer> stocks;
    private static final String CASH = "CASH";

    public MarginCall(int balance) {
        account = new HashMap<>();
        account.put(CASH, balance);
        stocks = new HashMap<>();
    }

    public List<List<String>> getUserPortfolio(String[][] tradeList) {
        for(String[] record : tradeList) {
            String action = record[2];
            String symbol = record[1];
            int quantity = Integer.parseInt(record[3]);
            int price = Integer.parseInt(record[4]);

            tradeStock(symbol, action, price, quantity);
        }

        return generatePortfolio();
    }

    public void tradeStock(String symbol, String action, int price, int quantity) {
        switch (action) {
            case("B") :{
                account.put(CASH, account.get(CASH) - price*quantity);
                account.put(symbol, account.getOrDefault(symbol,0) + quantity);
                break;
            } case "S":{
                account.put(CASH, account.get(CASH) + price*quantity);
                account.put(symbol, account.getOrDefault(symbol,0) - quantity);
                break;
            } default:
                throw new IllegalArgumentException("Not Supported Action: " + action);
        }
    }

    public List<List<String>> generatePortfolio() {
        List<List<String>> result = new ArrayList<>();
        int cash = 0;
        for(String key: account.keySet()) {
            if(key.equals(CASH)) {
                cash = account.get(key);
                continue;
            }
            List<String> item = new ArrayList<>();
            item.add(key);
            item.add(account.get(key).toString());
            result.add(item);
        }

        Collections.sort(result, (a,b) -> a.get(0).compareTo(b.get(0)));

        result.add(0,Arrays.asList("CASH", Integer.toString(cash)));
        return result;
    }

    public List<List<String>> getUserPortfolioWithMarginCall(String[][] records) {
        account = new HashMap<>();
        account.put(CASH, 1000);

        for(String[] record : records) {
            String action = record[2];
            String symbol = record[1];
            int quantity = Integer.parseInt(record[3]);
            int price = Integer.parseInt(record[4]);

            tradeStock(symbol, action, price, quantity);

            stocks.put(symbol, price);
            if(account.get(CASH) < 0) {
                marginCall();
            }

        }

        return generatePortfolio();
    }

    public List<List<String>> getUserPortfolioWithCollatoral(String[][] records) {
        account = new HashMap<>();
        stocks = new HashMap<>();
        account.put(CASH, 1000);

        for(String[] record : records) {
            String action = record[2];
            String symbol = record[1];
            int quantity = Integer.parseInt(record[3]);
            int price = Integer.parseInt(record[4]);

            tradeStock(symbol, action, price, quantity);

            stocks.put(symbol, price);
            if(account.get(CASH) < 0) {
                marginCallWithCollatoral();
            }

        }

        return generatePortfolio();
    }

    public void marginCallWithCollatoral() {
        int cash = account.get(CASH);

        PriorityQueue<String> stockQueue = new PriorityQueue<>((a,b) -> {
            if(stocks.get(a) != stocks.get(b)) {
                return stocks.get(b) - stocks.get(a);
            } else {
                return a.compareTo(b);
            }
        });
        for(String symbol : stocks.keySet()) {
            stockQueue.add(symbol);
        }

        while(cash < 0 && !stockQueue.isEmpty()) {
            String symbol = stockQueue.poll();
            int price = stocks.get(symbol);
            int quantity = account.get(symbol);

            if (!isCollateralStock(symbol) && account.containsKey(toCollateralStockFrom(symbol))) {
                if (account.get(symbol) <= account.get(toCollateralStockFrom(symbol))) {
                    continue;
                } else {
                    quantity = account.get(symbol) - account.get(toCollateralStockFrom(symbol));
                }
            }

            if(price * quantity >= Math.abs(cash)) {
                int shares = (Math.abs(cash) - 1) / price + 1;
                account.put(symbol, quantity - shares);
                cash += price * shares;
            } else {
                cash += price * quantity;
                account.put(symbol, account.get(symbol) - quantity);
            }

            if(account.get(symbol) == 0) {
                account.remove(symbol);
            }

            if(isCollateralStock(symbol)) {
                stockQueue.add(toStockFrom(symbol));
            }
        }

        account.put(CASH, cash);
    }

    public void marginCall() {
        int cash = account.get(CASH);

        PriorityQueue<String> stockQueue = new PriorityQueue<>((a,b) -> {
            if(stocks.get(a) != stocks.get(b)) {
                return stocks.get(b) - stocks.get(a);
            } else {
                return a.compareTo(b);
            }
        });
        for(String symbol : stocks.keySet()) {
            stockQueue.add(symbol);
        }

        while(cash < 0 && !stockQueue.isEmpty()) {
            String symbol = stockQueue.poll();

            int price = stocks.get(symbol);
            int quantity = account.get(symbol);
            if(price * quantity >= Math.abs(cash)) {
                int shares = (Math.abs(cash) - 1) / price + 1;
                account.put(symbol, quantity - shares);
                cash += price * shares;
            } else {
                cash += price * quantity;
                account.put(symbol, 0);
            }

            if(account.get(symbol) == 0) {
                account.remove(symbol);
            }

        }

        account.put(CASH, cash);
    }

    private boolean isCollateralStock(String symbol) {
        return symbol.charAt(symbol.length() - 1) == 'O';
    }

    private String toCollateralStockFrom(String symbol) {
        return symbol + "O";
    }

    private String toStockFrom(String collateral) {
        StringBuilder sb = new StringBuilder(collateral);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
