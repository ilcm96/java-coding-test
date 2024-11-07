package week01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().distinct().toList());
        Collections.sort(list);
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
