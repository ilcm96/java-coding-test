package week03_queue;

import java.util.ArrayDeque;

public class test15 {
    public static void main(String[] args) {
        // solution은 내가 푼 방법, solution1은 책의 정답
        System.out.println(solution(7, 3) == solution1(7, 3));
        System.out.println(solution(5, 2) == solution1(5, 2));
        System.out.println(solution(10, 3) == solution1(10, 3));
        System.out.println(solution(6, 3) == solution1(6, 3));
        System.out.println(solution(1, 1) == solution1(1, 1));
        System.out.println(solution(16, 3) == solution1(16, 3));
        System.out.println(solution(100, 3) == solution1(100, 3));
        System.out.println(solution(1000, 3) == solution1(1000, 3));
        System.out.println(solution(10000, 3) == solution1(10000, 3));
        System.out.println(solution(100000, 3) == solution1(100000, 3));
        System.out.println(solution(1232134, 100) == solution1(1232134, 100));
    }

    public static int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.poll();
    }

    // 책 정답
    public static int solution1(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pollFirst();
    }
}
