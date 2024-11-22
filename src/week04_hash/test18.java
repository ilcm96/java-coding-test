package week04_hash;

import java.util.HashSet;

public class test18 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9};
        int target = 10;
        System.out.println(solution(arr, target));

    }

    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }

        return false;
    }
}
