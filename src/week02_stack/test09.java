package week02_stack;

import java.util.Stack;

public class test09 {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }

    public static String solution(int number) {
        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

}
