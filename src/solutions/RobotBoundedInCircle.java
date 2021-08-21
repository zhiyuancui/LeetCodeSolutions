package solutions;

/**
 * 1041 Robot Bounded In Circle
 * https://leetcode-cn.com/problems/robot-bounded-in-circle/solution/zhong-gui-zhong-ju-1041-kun-yu-huan-zhon-5k29/
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if(instructions.length() < 1 || instructions.length() > 100) {
            return false;
        }

        int d = 0;

        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        int x = 0;
        int y = 0;

        for(char s : instructions.toCharArray()) {
            switch(s) {
                case 'R':
                    d+=1;
                    break;
                case 'L':
                    d += 3;
                    break;
                case 'G':
                    d = d % 4;
                    x += dx[d];
                    y += dy[d];
                    break;
            }
        }

        return (x == 0 && y == 0) || (d% 4 != 0);
    }
}
