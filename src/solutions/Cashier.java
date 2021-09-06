package solutions;

/**
 * 1357 Apply Discount Every n Orders
 */
public class Cashier {
    private final int total;
    private final int discount;
    private final int[] prices;
    private int curCount;


    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.curCount = 0;
        this.total = n;
        this.discount = discount;
        this.prices  = new int[201];
        for(int i = 0; i < products.length; i++) {
            this.prices[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        curCount++;
        double bill = 0.0;

        for(int i = 0; i < product.length; i++) {
            int item = product[i];
            int quant = amount[i];
            int price = this.prices[item];
            bill += quant * price;
        }

        if(total == curCount) {
            bill = bill - ((discount * bill) / 100);
            curCount = 0;
        }

        return bill;
    }
}
