package week04_hash;

import java.util.HashMap;

public class test19 {
    public static void main(String[] args) {

    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String person : completion) {
            Integer i = hashMap.get(person);
            if (i != null) {
                hashMap.put(person, ++i);
            } else {
                hashMap.put(person, 1);
            }
        }

        for (String person : participant) {
            Integer i = hashMap.get(person);
            if (i == null || i == 0) {
                return person;
            }
            hashMap.put(person, hashMap.get(person) - 1);
        }

        return null;
    }
    
}
