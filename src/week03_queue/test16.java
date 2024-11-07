package week03_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test16 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

        List<Integer> answer = new ArrayList<>();
        int count = 1;
        int maxDay = days[0];

        for (int i = 1; i < n; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDay = days[i];
            }
        }
        answer.add(count);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
