package solutions;

public class ProductOfNumbers {
    int[] pre = new int[40010];
    int len = 0;
    public ProductOfNumbers() {
        pre[0] = 1;
    }

    public void add(int num) {
        if(num == 0) {
            len = 0;
        } else {
            len++;
            pre[len] = num;
            pre[len] *= pre[len - 1];
        }
    }

    public int getProduct(int k) {
        if(len < k) {
            return 0;
        }

        return pre[len] / pre[len-k];
    }
}
