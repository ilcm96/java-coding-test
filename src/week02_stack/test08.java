package week02_stack;

import java.util.Stack;

public class test08 {

    public static void main(String[] args) {
        System.out.println(solution("())"));
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution("((()"));
        System.out.println(solution(""));
    }

    public static boolean solution(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;  // 스택이 비어있는데 닫는 괄호가 나오면 false
                }
                stack.pop();
            }
        }

        return stack.isEmpty();  // 모든 괄호가 올바르게 닫혔는지 확인
    }
}
