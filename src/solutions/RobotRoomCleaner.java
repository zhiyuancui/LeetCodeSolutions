package solutions;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    class Robot {
        public void turnRight() {
            System.out.println("turn right");
        }
        public void turnLeft() {
            System.out.println("turn left");
        }
        public boolean move() {
            return true;
        }
        public void clean(){
            System.out.println("clean");
        }
    }

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int x, int y, int d) {
        visited.add(new Pair(x, y));
        robot.clean();

        for(int i = 0; i < 4; i++) {
            int newD = (d+i) % 4;
            int newX = x + directions[newD][0];
            int newY = y + directions[newD][1];

            if(!visited.contains(new Pair(newX, newY)) && robot.move()) {
                backtrack(newX, newY, newD);
                goBack();
            }

            robot.turnRight();
        }
    }


    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0,0,0);
    }
}
