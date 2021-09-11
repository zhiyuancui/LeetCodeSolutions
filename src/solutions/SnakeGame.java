package solutions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 353 Design Snake Game
 */
public class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    Set<Integer> set;
    Deque<Integer> body;
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        set = new HashSet<>();
        set.add(0);
        body = new LinkedList<>();
        body.addLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == -1) {
            return -1;
        }

        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;

        switch(direction) {
            case "U":
                rowHead--;
                break;
            case "D":
                rowHead++;
                break;
            case "L":
                colHead--;
                break;
            default:
                colHead++;

        }

        int head = rowHead * width + colHead;

        set.remove(body.peekLast());

        if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            score = -1;
            return score;
        }

        set.add(head);
        body.offerFirst(head);

        if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast());
            foodIndex++;
            score++;
            return score;
        }

        body.pollLast();
        return score;
    }
}
