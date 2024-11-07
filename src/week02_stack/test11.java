package week02_stack;

import java.util.Stack;

public class test11 {

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int length = arr.length;

        for (char c : arr) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
