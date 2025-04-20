/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n)
 * 메모리: 83400 kb
 * 시간: 1236 ms
 *******************************************************************************/
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tree_parents {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 저장 파트
        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            tree[a].add(b);
            tree[b].add(a);
        }

        // 부모 정보 저장 배열
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트 노드는 1로 지정
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;  // 부모 노드 기록 부분
                    queue.offer(next);
                }
            }
        }

        // 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
