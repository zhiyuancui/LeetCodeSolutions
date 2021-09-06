package solutions.amazon.oa.Sep;

public class SecretArray {
    // 根据differences找到nums中‍‌‌‍‌‍‌‌‌‌‍‌‌‌‍‌‍最大和最小数字的difference1；用upper_bound减去lower_bound找到允许的最大difference2；最后difference2 - difference1 + 1就是结果
    public int countSecretPairs(int upperBound, int lowerBound, int[] diff) {
        int lowest = 0;
        int highest = 0;
        int sum = 0;

        for(int value : diff) {
            sum += value;
            highest = Math.max(sum, highest);
            lowest = Math.min(sum, lowest);
        }

        int maxRange = upperBound - lowerBound;
        int maxDiff = highest - lowest;

        if(maxDiff > maxRange) {
            return -1;
        }


        return maxRange - maxDiff + 1;
    }

    public static void main(String[] args) {
        SecretArray s = new SecretArray();

//        System.out.println("Expected: 2");
//        System.out.println("Actual: " + s.countSecretPairs(10, 3, new int[]{-1,-2,-3}));
//        System.out.println("--------------------------------------");
//
//        System.out.println("Expected: 2");
//        System.out.println("Actual: " + s.countSecretPairs(7, 1, new int[]{1,-1,2,3}));
//        System.out.println("--------------------------------------");
//
//        System.out.println("Expected: 2");
//        System.out.println("Actual: " + s.countSecretPairs(10, 3, new int[]{1,2,3}));
//        System.out.println("--------------------------------------");

        System.out.println("Expected: 6");
        System.out.println("Actual: " + s.countSecretPairs(10, 3, new int[]{1,-2,3}));
        System.out.println("--------------------------------------");
    }
}
