package week01_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test06 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] stagePlayers = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {
            stagePlayers[stages[i]]++;
        }

        HashMap<Integer, Double> map = new HashMap<>();
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            if (stagePlayers[i] == 0) {
                map.put(i, 0.);
            } else {
                map.put(i, (stagePlayers[i] / (double) length));
                length = length - stagePlayers[i];
            }
        }


        return map.entrySet().stream().sorted(
                (a, b) -> b.getValue().compareTo(a.getValue())
        ).mapToInt(Map.Entry::getKey).toArray();
    }
}
