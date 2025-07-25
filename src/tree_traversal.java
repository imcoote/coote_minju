/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 14160 kb
 * 시간: 108	 ms
 *******************************************************************************/
// 루트가 'A'인 이진 트리가 주어짐
// 각 노드에 대해 왼쪽 자식, 오른쪽 자식 정보가 입력됨
// 이 트리를 기준으로 전위(preorder), 중위(inorder), 후위(postorder) 순회 결과를 출력하는 프로그램
import java.io.*;
import java.util.*;

public class tree_traversal {
    // 트리 노드 정의
    // Map<Character, Node> 구조를 사용해 알파벳 기준으로 트리 저장
    // 각 노드는 왼쪽 자식과 오른쪽 자식 정보를 갖고 있음
    static class Node {
        char left, right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 트리 정보 입력받기
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            char parent = parts[0].charAt(0);
            char left = parts[1].charAt(0);
            char right = parts[2].charAt(0);
            tree.put(parent, new Node(left, right));
        }

        // 결과 출력 부분
        preorder('A');   // 전위
        System.out.println();
        inorder('A');    // 중위
        System.out.println();
        postorder('A');  // 후위
        System.out.println();
    }

    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    static void preorder(char node) {
        if (node == '.') return;
        System.out.print(node); // 루트
        preorder(tree.get(node).left);  // 왼쪽
        preorder(tree.get(node).right); // 오른쪽
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void inorder(char node) {
        if (node == '.') return;
        inorder(tree.get(node).left);   // 왼쪽
        System.out.print(node);         // 루트
        inorder(tree.get(node).right);  // 오른쪽
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void postorder(char node) {
        if (node == '.') return;
        postorder(tree.get(node).left);  // 왼쪽
        postorder(tree.get(node).right); // 오른쪽
        System.out.print(node);          // 루트
    }
}