package week01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test04 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5}, // 5
                {2, 1, 2, 3, 2, 4, 2, 5}, // 8
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 10
        };

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    score[j]++;
                }
            }
        }

        int max = Arrays.stream(score).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
