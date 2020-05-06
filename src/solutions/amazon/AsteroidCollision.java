package solutions.amazon;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();

        for(int aster: asteroids) {
            boolean isContinue = false;
            while(!stack.isEmpty() && aster < 0 && 0 < stack.peek()) {
                if(stack.peek() < -aster) {
                    stack.pop();
                    continue;
                } else if(stack.peek() == -aster) {
                    stack.pop();
                }
                isContinue = true;
                break;

            }
            if(isContinue) {
                continue;
            }
            stack.push(aster);
        }

        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
