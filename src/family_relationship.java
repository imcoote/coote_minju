/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(M × N)
 * 메모리: 14424 kb
 * 시간: 100 ms
 *******************************************************************************/
// 촌수 계산
// 결과적으로 두 노드 간의 최단거리 구하기
import java.io.*;
import java.util.*;

public class family_relationship {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        dist[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neigh : graph[current]) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    dist[neigh] = dist[current] + 1;

                    if (neigh == target) {
                        return dist[neigh];
                    }

                    queue.add(neigh);
                }
            }
        }

        return -1; // 연결 안됨
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        int m = Integer.parseInt(br.readLine()); // 부모 자식 관계 수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            graph[x].add(y);
            graph[y].add(x);
        }

        int answer = bfs(a, b);
        System.out.println(answer);
    }
}
