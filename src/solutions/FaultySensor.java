package solutions;

public class FaultySensor {
    public int badSensor(int[] sensor1, int[] sensor2) {
        if(sensor1 == null || sensor2 == null) {
            return 0;
        }

        int len = sensor1.length;

        for(int i = 0; i < sensor1.length; i++) {
            if(sensor1[i] != sensor2[i]) {
                if(sensor1[i] == sensor1[len -1] && sensor2[i] == sensor2[len-1]) {
                    return -1;
                }

                while(i + 1 < len && sensor1[i] == sensor2[i+1]) {
                    i++;
                }
                return i + 1 == len ? 1 : 2;
            }
        }

        return -1;
    }
}
