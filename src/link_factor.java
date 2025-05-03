/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N + M)
 * 메모리: 172936 kb
 * 시간: 676 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class link_factor {
    static List<Integer>[] graph;  // 인접 리스트
    static boolean[] visited;      // 방문 체크할 배열

    // 연결 요소 탐색 (BFS)
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 누적용

        // n: 정점 수, m: 간선 수
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        graph = new ArrayList[n + 1];  // 1번 노드부터 사용
        visited = new boolean[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            graph[v].add(u); // 무방향
        }

        int count = 0; // 연결 요소 개수

        // 모든 정점 돌면서 연결 요소 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        sb.append(count).append('\n');
        System.out.print(sb);
    }
}
