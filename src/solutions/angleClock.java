package solutions;

/**
 * 1344 Angle Between Hands of a Clock
 */
public class angleClock {
    public double angleClock(int hour, int minutes) {

        double mangle = 360 * minutes / 60.0;

        double hangle = (hour%12) * 360 / 12.0 + minutes / 2.0;

        // System.out.println("minutes angle: " + mangle);
        // System.out.println("hour angle: " + hangle);

        double angle = Math.abs(mangle - hangle);

        if(Math.abs(360 - angle) < angle) {
            return Math.abs(360 - angle);
        } else {
            return angle;
        }

    }
}
