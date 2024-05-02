class MinOperationsToZero {
/**
 * 2357. Make Array Zero by Subtracting Equal Amounts
 */
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a: nums)
            if (a > 0)
                set.add(a);
        return set.size();
    }
}