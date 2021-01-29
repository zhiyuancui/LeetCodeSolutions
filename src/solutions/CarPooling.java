package solutions;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];

        for(int[] trip: trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for(int number : timestamp) {
            usedCapacity += number;
            if(usedCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}
