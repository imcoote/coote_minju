/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(m log n)
 * 메모리: 47892 kb
 * 시간: 356	 ms
 *******************************************************************************/
// s와 t가 처음으로 연결되기까지의 최소 가중치 합!!
// 우리는 s와 t가 같은 그룹이 되는 시점까지만 가중치가 작은 간선부터 차례로 그래프에 추가하는 것
import java.io.*;
import java.util.*;

public class 간선_two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 정점 수(n), 간선 수(m) 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점 수 (1부터 n번까지 존재)
        int m = Integer.parseInt(st.nextToken());   // 간선 수

        // 인접 리스트 생성: 각 정점마다 연결된 간선 리스트를 저장 (to, weight)
        List<int[]>[] graph = new ArrayList[n + 1]; // 1번부터 n번 정점까지 쓰기 위해 n+1
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 각 정점에 대한 리스트 초기화
        }

        // 간선 정보 입력 받아 인접 리스트에 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 간선 시작 정점
            int b = Integer.parseInt(st.nextToken()); // 간선 끝 정점
            int c = Integer.parseInt(st.nextToken()); // 간선 가중치

            graph[a].add(new int[]{b, c}); // a -> b 가중치 c
            graph[b].add(new int[]{a, c}); // b -> a 가중치 c (무방향 그래프이기 때문에 반대도 추가)
        }

        // s: 시작 정점, t: 도착 정점
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // Dijkstra 알고리즘을 위한 거리 배열 (dist[i] = s에서 i까지의 최단 거리)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기에는 모두 무한대로 설정
        dist[s] = 0; // 시작 정점은 거리 0으로 설정

        // 우선순위 큐(PriorityQueue): 현재까지 거리(dist)가 가장 짧은 정점을 먼저 꺼냄
        // int[]{정점 번호, 거리} 형태로 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0}); // 시작 정점을 큐에 넣음

        // 본격적인 Dijkstra 루프 시작
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // 가장 가중치가 작은 = 거리가 가까운 정점 꺼냄
            int v = cur[0];        // 현재 정점 번호
            int d = cur[1];        // 현재 정점까지의 거리

            if (d > dist[v]) continue; // 이미 더 짧은 거리로 방문한 경우 무시
            if (v == t) break;         // 목적지에 도달했으면 종료 (최단 거리 확정)

            // 현재 정점과 연결된 모든 이웃 정점 확인
            for (int[] edge : graph[v]) {
                int next = edge[0];       // 다음 정점
                int weight = edge[1];     // 현재 간선의 가중치
                int nd = d + weight;      // 현재까지 거리 + 간선 가중치

                // 더 짧은 경로 발견 시 갱신
                if (nd < dist[next]) {
                    dist[next] = nd;
                    pq.offer(new int[]{next, nd}); // 큐에 갱신된 경로 추가
                }
            }
        }

        // 최종적으로 s에서 t까지의 최단 거리 출력
        System.out.println(dist[t]);
    }
}


