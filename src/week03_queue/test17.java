package week03_queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class test17 {

    public static void main(String[] args) {
        { // Yes
            String[] cards1 = {"i", "drink", "water"};
            String[] cards2 = {"want", "to"};
            String[] goal = {"i", "want", "to", "drink", "water"};

            System.out.println(solution(cards1, cards2, goal));
        }
        { // No
            String[] cards1 = {"i", "water", "drink"};
            String[] cards2 = {"want", "to"};
            String[] goal = {"i", "want", "to", "drink", "water"};

            System.out.println(solution(cards1, cards2, goal));
        }
    }

    public static String solution(
            String[] cards1,
            String[] cards2,
            String[] goal
    ) {
        ArrayDeque<String> dequeCard1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> dequeCard2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> dequeGoal = new ArrayDeque<>(Arrays.asList(goal));

        while (!dequeGoal.isEmpty()) {
            String target = dequeGoal.poll();
            if (!dequeCard1.isEmpty() && dequeCard1.peek().equals(target)) {
                dequeCard1.poll();
            } else if (!dequeCard2.isEmpty() && dequeCard2.peek().equals(target)) {
                dequeCard2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
    
}
