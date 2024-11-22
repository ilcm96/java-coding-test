package week05_tree;

import java.util.HashMap;

public class test27 {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        solution(enroll, referral, seller, amount);

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> nameMoneyMap = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String currentNode = seller[i];

            while (money > 0 && !currentNode.equals("-")) {
                nameMoneyMap.put(currentNode, nameMoneyMap.getOrDefault(currentNode, 0) + money - (money / 10));
                currentNode = parent.get(currentNode);
                money = money / 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = nameMoneyMap.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
