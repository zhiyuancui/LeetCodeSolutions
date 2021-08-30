package solutions.doordash;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-787537-1-1.html
 */
public class CountTimeDiff {
    public List<String> solution(String[] input) throws Exception{
        if(input.length <= 1) {
            return new ArrayList<>();
        }

        int time1 = parseDate(input[0]);
        int time2 = parseDate(input[1]);

        List<String> result = new ArrayList<>();

        if(time2 < time1) {
            addSlots(time1, 72400, result);
            int lastDate = Integer.parseInt(result.get(result.size() - 1));
            int minute = lastDate % 100 + 5 - 60;
            addSlots(10000 + minute, time2, result);
            //throw new IllegalArgumentException();
        } else {
            addSlots(time1, time2, result);
        }

        return result;
    }

    private void addSlots(int time1, int time2, List<String> result) {
        int start = time1;
        while(start <= time2) {
            result.add(Integer.toString(start));
            start += 5;
            int minute = start % 100;
            if(minute >= 60) {
                int next = start / 100;
                next++;
                start = next * 100 + (minute - 60);
            }
            if(isNextDate(start)) {
                start = toNextDay(start);
            }
        }
    }

    /**
     * 如果限定了open hour只能在同一天
     * @param date
     * @return
     */
    private boolean isNextDate(int date) {
        int dayOfWeek = date / 10000;

        return date > (dayOfWeek * 10000 + 2359);
    }

    private int toNextDay(int date) {
        int minute = date % 100;
        int dayOfWeek = date / 10000;

        return (dayOfWeek+1) * 10000 + minute;
    }

    private int parseDate(String date) {
        String[] split = date.split("\\s+");

        int base = 10000;

        switch (split[0]) {
            case "mon":
                base = base * 1;
                break;
            case "tue":
                base = base * 2;
                break;
            case "wed":
                base = base * 3;
                break;
            case "thu":
                base = base * 4;
                break;
            case "fri":
                base = base * 5;
                break;
            case "sat":
                base = base * 6;
                break;
            case "sun":
                base = base * 7;
                break;
        }

        switch (split[2]) {
            case "am":
                break;
            case "pm":
                base += 1200;
                break;
        }

        String[] time = split[1].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        return base + hour * 100 + minute;
    }

    public static void main(String[] args) {
        CountTimeDiff c = new CountTimeDiff();
        String[] input = new String[]{"mon 11:52 am", "mon 1:13 pm"};
        try {
            c.solution(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
