package week04_hash;

import java.util.*;

public class test24 {

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        System.out.println(Arrays.toString(solution(orders, course)));

    }

    public static String[] solution(String[] orders, int[] course) {

        HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            order = new String(orderArr);

            for (int courseCount : course) {
                List<String> combinations = combination(order, courseCount);
                for (String combination : combinations) {
                    if (!courseMap.get(courseCount).containsKey(combination)) {
                        courseMap.get(courseCount).put(combination, 0);
                    }
                    courseMap.get(courseCount)
                            .put(combination, courseMap.get(courseCount)
                                    .get(combination) + 1);
                }
            }
        }
        System.out.println(courseMap);
        List<String> result = new ArrayList<>();

        for (Map<String, Integer> group : courseMap.values()) {
            if (group.isEmpty()) {
                continue;
            }
            int maxCount = Collections.max(group.values());
            if (maxCount < 2) {
                continue;
            }

            for (Map.Entry<String, Integer> entry : group.entrySet()) {
                if (entry.getValue() == maxCount) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public static List<String> combination(String str, int r) {
        List<String> combinations = new ArrayList<>();
        generateCombinations(str, r, 0, "", combinations);
        return combinations;
    }

    public static void generateCombinations(
            String str,
            int r,
            int start,
            String current,
            List<String> combinations) {
        if (current.length() == r) {
            combinations.add(current);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            generateCombinations(str, r, i + 1, current + str.charAt(i), combinations);
        }
    }
}
