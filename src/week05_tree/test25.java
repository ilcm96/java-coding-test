package week05_tree;

import java.util.Arrays;

public class test25 {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution(input)));
    }

    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();

        return result;
    }

    public static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return nodes[idx] + " " +
                preorder(nodes, 2 * idx + 1) +
                preorder(nodes, 2 * idx + 2);
    }

    public static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx + 1) +
                nodes[idx] + " " +
                inorder(nodes, 2 * idx + 2);
    }

    public static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2 * idx + 1) +
                postorder(nodes, 2 * idx + 2) +
                nodes[idx] + " ";
    }
}
