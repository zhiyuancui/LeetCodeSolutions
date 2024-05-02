class MinKeyPress {
    /**
     * 2268 Minimum Number of Keypresses
     */
    public int minimumKeypresses(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a'] += 1;
        }

        Arrays.sort(arr);

        int min = 0;
        int inc = 1;
        int count = 0;
        for(int i = 25; i >= 0; i--){
            if(arr[i] > 0){
                min += arr[i] * inc;
                count += 1;
                if(count == 9){
                    inc += 1;
                    count = 0;
                }
            }
        }

        return min;
    }
}