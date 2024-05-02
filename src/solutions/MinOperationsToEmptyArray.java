class MinOperationsToEmptyArray {
    /**
     * 2870. Minimum Number of Operations to Make Array Empty
     */
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0;
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int value : map.values()) {
            if(value == 1) {
                return -1;
            }
            count += value / 3;
            if(value % 3 != 0) {
                count++;
            }
        }

        return count;
    }
}