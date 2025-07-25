/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N + Q)
 * 메모리: 73140 kb
 * 시간: 792	 ms
 *******************************************************************************/
// DFS로 탐색
import java.io.*;
import java.util.*;

public class TreeAndQuery {
    // 인접 리스트 방식으로 트리 구조 저장
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] subtreeSize; // 노드 u를 루트로 하는 서브트리 크기 저장
    static boolean[] visited; // DFS 방문 여부 체크용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int R = Integer.parseInt(st.nextToken()); // 트리의 루트 노드 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 수

        // 인덱스 0은 사용 안 하고, 1부터 9까지 사용
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u); // 무방향 그래프
        }

        // DFS로 서브트리 크기 계산
        dfs(R);

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[u]).append("\n");
        }

        System.out.print(sb);
    }

    // DFS를 통한 서브트리 크기 계산
    // current: 현재 탐색 중인 노드
    // 현재 노드부터 뻗어나가는 모든 자식들을 세서 서브트리 크기를 구하는 역할
    static int dfs(int current) {
        visited[current] = true; // 현재 노드를 방문했음을 표시
        subtreeSize[current] = 1; // 자기 자신 포함 -> 즉, 최소 서브트리 크기는 자기 자신 하나

        // 현재 노드 current에 연결된 모든 인접 노드(자식들)를 반복
        for (int child : tree.get(current)) {
            if (!visited[child]) { // 방문하지 않은 자식 노드만 재귀 호출-> 위에서 방문 체크를 했기 때문에 부모 노드로 거꾸로 가는 걸 방지 가능
                // 자식 노드의 서브트리 크기를 더함
                //즉, 재귀적으로 내려가면서 자식들이 몇 명인지 알아낸 뒤 그 숫자를 더함
                subtreeSize[current] += dfs(child);
                // 예: current = 3, 자식이 1(leaf), 2(leaf)이면
                //→ dfs(1) = 1, dfs(2) = 1
                //→ subtreeSize[3] = 1 + 1 + 1 = 3
            }
        }

        return subtreeSize[current];
    }
}
