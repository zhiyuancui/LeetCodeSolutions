package solutions.amazon;

import java.util.Stack;

/**
 * 735 Asteroid Collision
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            boolean skip = false;
            while(!stack.isEmpty() && asteroid < 0 && 0 < stack.peek()) {
                if(stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if(stack.peek() == -asteroid) {
                    skip = true;
                    stack.pop();
                    break;
                } else {
                    skip = true;
                    break;
                }
            }
            if(!skip) {
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
