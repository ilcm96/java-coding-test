package week04_hash;

import java.util.HashMap;

public class test20 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantNumber = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            wantNumber.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                hashMap.put(discount[j], hashMap.getOrDefault(discount[j], 0) + 1);
            }
            if (wantNumber.equals(hashMap)) {
                answer++;
            }
        }

        return answer;
    }
    
}
