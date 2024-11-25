/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n * m)
 * 메모리: 19052 kb
 * 시간: 208 ms
 *******************************************************************************/
import java.util.*;

public class MazeSearch {
    static int n, m;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 1});
        graph[a][b] = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int dist = point[2];


            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = 0; // 방문 처리
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}

