package solutions;

/**
 * 1860 Incremental Memory Leak
 */
public class IncrementalMemoryLeak {
    public int[] memLeak(int memory1, int memory2) {
        if(memory1 < 0 || memory2 < 0) {
            return new int[]{};
        }

        int count = 1;

        while(memory1 >= 0 && memory2 >= 0) {
            if(memory1 >= memory2) {
                memory1 -= count;
            } else {
                memory2 -= count;
            }

            count++;
        }
        count--;
        int[] result = new int[]{count, memory1, memory2};

        if(result[1] < 0) {
            result[1] += count;
        } else {
            result[2] += count;
        }

        return result;
    }
}
