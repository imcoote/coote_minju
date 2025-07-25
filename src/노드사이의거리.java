/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(M × N)
 * 메모리: 19572 kb
 * 시간: 196	 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class 노드사이의거리 {
    static List<List<int[]>> tree = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 쿼리 수

        // 트리 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree.get(u).add(new int[]{v, d});
            tree.get(v).add(new int[]{u, d});
        }

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            sb.append(dfs(start, end, 0)).append("\n");
        }

        System.out.print(sb);
    }

    // DFS 함수 - 거리 반환
    static int dfs(int current, int target, int dist) {
        // 현재 노드가 우리가 찾는 target이라면 지금까지 누적해온 거리 dist를 반환하고 탐색 종료
        if (current == target) return dist;

        visited[current] = true; // 무방향 그래프(트리)이기 때문에 이미 방문한 노드를 다시 가지 않도록 방문 체크

        // tree는 인접 리스트
        // 현재 노드에서 연결된 모든 노드를 하나씩 꺼냄
        for (int[] next : tree.get(current)) {
            int to = next[0];
            int weight = next[1];

            // 방문하지 않은 노드에 대해서 DFS 재귀 호출
            if (!visited[to]) {
                int result = dfs(to, target, dist + weight); // dist + weight: 현재 거리 누적 + 새로 가는 간선의 가중치를 더해서 넘겨줌

                // DFS 호출 결과가 -1이 아니라면 (= 목적지까지 도달한 경로라면)
                // 그 거리값을 부모 호출로 그대로 반환함
                // 더 이상 다른 노드로 탐색할 필요 없음 (경로는 트리 구조상 유일하니까)
                if (result != -1) return result; // target까지 도달한 경우
            }
        }

        return -1; // 못 찾은 경우
    }
}

// BFS
//import java.io.*;
//import java.util.*;
//
//public class 노드사이의거리_BFS {
//    static List<List<int[]>> tree = new ArrayList<>();
//    static boolean[] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken()); // 노드 수
//        int M = Integer.parseInt(st.nextToken()); // 쿼리 수
//
//        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
//
//        for (int i = 0; i < N - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int d = Integer.parseInt(st.nextToken());
//
//            tree.get(u).add(new int[]{v, d});
//            tree.get(v).add(new int[]{u, d});
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//
//            visited = new boolean[N + 1];
//            sb.append(bfs(start, end)).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    static int bfs(int start, int target) {
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{start, 0});
//        visited[start] = true;
//
//        while (!q.isEmpty()) {
//            int[] now = q.poll();
//            int cur = now[0];
//            int dist = now[1];
//
//            if (cur == target) return dist;
//
//            for (int[] next : tree.get(cur)) {
//                int to = next[0];
//                int weight = next[1];
//
//                if (!visited[to]) {
//                    visited[to] = true;
//                    q.offer(new int[]{to, dist + weight});
//                }
//            }
//        }
//
//        return -1; // 실제 트리에선 이 경우 없음
//    }
//}

