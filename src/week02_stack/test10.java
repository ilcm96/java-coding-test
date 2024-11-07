package week02_stack;

import java.util.HashMap;
import java.util.Stack;

public class test10 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
    }

    public static int solution(String s) {
        int answer = 0;
        char[] arr = (s + s).toCharArray();
        int length = arr.length / 2;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Out:
        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < i + length; j++) {
                char c = arr[j];
                if (map.containsKey(c)) { // 열린 괄호일 경우
                    stack.push(c);
                } else { // 닫힌 괄호일 경우
                    if (stack.isEmpty()) {
                        // 닫힌 괄호인데 스택이 비어있다면 올바르지 않은 괄호 문자열
                        continue Out;
                    }
                    char open = stack.pop();
                    if (c != map.get(open)) {
                        // 스택에서 꺼낸 열린 괄호와 현재 닫힌 괄호가 매칭되지 않음
                        continue Out;
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
