package week04_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test21 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();

        for (String line : record) {
            String[] a = line.split(" ");
            if (a[0].equals("Enter") || a[0].equals("Change")) {
                user.put(a[1], a[2]);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String log : record) {
            String[] a = log.split(" ");
            if (a[0].equals("Enter")) {
                answer.add(user.get(a[1]) + "님이 들어왔습니다.");
            } else if (a[0].equals("Leave")) {
                answer.add(user.get(a[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }

}
