package week02_stack;

import java.util.Stack;

public class test13 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int columns = board.length;
        int rows = board[0].length;

        Stack<Integer>[] verticals = new Stack[columns];
        for (int i = 0; i < columns; i++) {
            verticals[i] = new Stack<>();
        }

        for (int i = columns - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                if (board[i][j] > 0) {
                    verticals[j].push(board[i][j]);
                }
            }
        }

        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            move = move - 1;
            if (!verticals[move].isEmpty()) {
                int caught = verticals[move].pop();
                if (!basket.isEmpty() && (caught == basket.peek())) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(caught);
                }
            }
        }

        return answer;
    }

}
