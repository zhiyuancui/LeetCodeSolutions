package solutions;

public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int count = 0;
        int ptrT = 0;

        while(ptrT < target.length()) {
            int ptrS = 0;
            boolean found = false;

            while(ptrS < source.length() && ptrT < target.length()) {
                if(source.charAt(ptrS) == target.charAt(ptrT)) {
                    found = true;
                    ptrT++;
                }
                ptrS++;
            }
            if(!found) return -1;
            count++;
        }

        return count;
    }
}
