package week04_hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class test23 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한사람: 신고한 사람
        HashMap<String, HashSet<String>> reportedMap = new HashMap<>();

        for (String r : report) {
            String[] arr = r.split(" ");
            String reporter = arr[0];
            String reported = arr[1];

            if (!reportedMap.containsKey(reported)) {
                reportedMap.put(reported, new HashSet<>());
            }
            reportedMap.get(reported).add(reporter);
        }

        HashMap<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, HashSet<String>> entry : reportedMap.entrySet()) {
            if (entry.getValue().size() > k - 1) {
                for (String reporter : entry.getValue()) {
                    countMap.put(reporter, countMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            result[i] = countMap.getOrDefault(id_list[i], 0);
        }

        return result;
    }
}
