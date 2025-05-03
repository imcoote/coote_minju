/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(M × N)
 * 메모리: 14624 kb
 * 시간: 112 ms
 *******************************************************************************/
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baby_shark {
    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist; // 거리 넣을 변수
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m]; // 아기 상어와의 안전거리를 넣을 배열
        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // 8방향 이동
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = current.dist + 1;
                    queue.add(new Node(nx, ny, current.dist + 1));
                }
            }
        }

        // 안전 거리 찾기
        int max_num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max_num = Math.max(max_num, dist[i][j]);
            }
        }

        System.out.println(max_num);
    }
}

