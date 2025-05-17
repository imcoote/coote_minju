/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(N × (N + M))
 * 메모리: 18584 kb
 * 시간: 196 ms
 ***************************************************************************/
/**
 1. 인접 리스트로 노드 구현 -> 그래프 제작
 2. 1번 회원부터 시작하여 모든 회원을 한 명씩 검사한다.
 3. 현재 검사 중인 회원에서 bfs를 시작한다.(자신과 직접 연결된 친구들을 큐에 담음)+거리 배열(dist[])에 본인 기준 거리 = 0으로 초기화한다.
 4. 큐에 담겨진 노드를 하나씩 꺼내면서 연결된 친구들을 순회한다. -> 큐가 빌 때까지 반복하며 모든 친구들과의 최소 거리를 기록한다.
 5.  모든 노드까지의 거리 중 가장 멀리 있는 거리 = 해당 회원의 점수로 저장한다. -> 반복
 6. 점수가 가장 낮은 회원(들)을 회장 후보로 정한다.
 **/

import java.util.*;

public class president_election {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 회원 수

        // 1. 인접 리스트로 노드 구현 → 그래프 제작
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) break;
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] scores = new int[N + 1]; // 각 회원의 점수 저장

        // 2. 1번 회원부터 시작하여 모든 회원을 한 명씩 검사한다.
        for (int i = 1; i <= N; i++) {

            // 3. 현재 검사 중인 회원에서 BFS를 시작한다.
            int[] dist = new int[N + 1];
            Arrays.fill(dist, -1); // -1은 아직 방문 안 한 상태
            Queue<Integer> q = new LinkedList<>();
            dist[i] = 0; // 거리 배열(dist[])에 본인 기준 거리 = 0으로 초기화한다.
            q.add(i);

            // 4. 큐에 담겨진 노드를 하나씩 꺼내면서 연결된 친구들을 순회한다.(큐가 빌 때까지 반복)
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : graph[now]) {
                    if (dist[next] == -1) {
                        dist[next] = dist[now] + 1;
                        q.add(next);
                    }
                }
            }

            // 5. 모든 노드까지의 거리 중 가장 멀리 있는 거리 = 해당 회원의 점수로 저장한다. → 반복
            int score = 0;
            for (int j = 1; j <= N; j++) {
                score = Math.max(score, dist[j]);
            }
            scores[i] = score;
        }

        // 6. 점수가 가장 낮은 회원(들)을 회장 후보로 정한다.
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            minScore = Math.min(minScore, scores[i]);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());
        for (int c : candidates) {
            System.out.print(c + " ");
        }
    }
}


