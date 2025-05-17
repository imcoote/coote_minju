/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 14320 kb
 * 시간: 104 ms
 *******************************************************************************/
/**
 1. 트리를 이쁘게 만든다.
 2. 삭제하고 싶은 노드로 이동한다.
 3. 그 노드의 요소를 큐에 담고 그 노드는 그래프에서 삭제한다.
 4. 큐에 담겨진 요소가 노드인 곳으로 이동(이동할 때 큐에서 꺼내고 그 꺼내진 요소의 값(노드)로 이동)
 5. 그 노드의 요소를 또 큐에 담고 그 노드 그래프에서 삭제한다.->반복
 6. 큐에서 다 꺼냈으면 이제 그래프 검사해서 리프 노드 개수 탐색한다.
 **/
import java.io.*;
import java.util.*;

public class tree {
    static List<Integer>[] tree;
    static boolean[] deleted;
    static int N, deleteNode, root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        deleted = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int child = 0; child < N; child++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = child;
            } else {
                tree[parent].add(child);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        // 1. BFS로 삭제 대상 노드와 그 자식들 삭제 표시
        deleteSubtree(deleteNode);

        // 2. 리프 노드 개수 세기
        int leafCount = countLeafNodes(root);
        System.out.println(leafCount);
    }

    static void deleteSubtree(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        deleted[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int child : tree[current]) {
                if (!deleted[child]) {
                    deleted[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    static int countLeafNodes(int node) {
        if (deleted[node]) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int leafCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (deleted[current]) continue;

            boolean isLeaf = true;
            for (int child : tree[current]) {
                if (!deleted[child]) {
                    queue.add(child);
                    isLeaf = false;
                }
            }

            if (isLeaf) {
                leafCount++;
            }
        }

        return leafCount;
    }
}


