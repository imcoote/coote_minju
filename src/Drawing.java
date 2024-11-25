/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n * m)
 * 메모리: 225276 kb
 * 시간: 1044 ms
 *******************************************************************************/
import java.util.*;

public class Drawing {
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
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 그림 개수와 최대 크기 계산
        ArrayList<Integer> paint = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    paint.add(bfs(i, j));
                }
            }
        }

        // 출력 처리
        if (paint.size() == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(paint.size());
            System.out.println(Collections.max(paint));
        }
    }

    public static int bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        graph[a][b] = 0;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 연결된 부분이 1인 경우 큐에 추가
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }
}
