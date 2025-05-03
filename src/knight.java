/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: T×O(l^2)
 * 메모리: 115004 kb
 * 시간: 324 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class knight {
    // 좌표 저장용 노드 클래스
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int l; // 체스판 한 변의 길이
    static int[][] dist; // 이동 횟수 저장 배열
    static boolean[][] visited; // 방문 체크

    // 나이트 이동 방향 (총 8방향)
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    // BFS로 최소 이동 횟수 계산
    static void bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        dist[startX][startY] = 0; // 시작 위치는 0

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 8방향으로 이동
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 체크 + 미방문 + 큐 삽입
                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[current.x][current.y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine()); // 체스판 사이즈
            dist = new int[l][l];
            visited = new boolean[l][l];

            // 시작, 도착 좌표
            String[] start = br.readLine().split(" ");
            String[] end = br.readLine().split(" ");
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);

            // BFS 실행
            bfs(startX, startY);

            // 결과 누적
            sb.append(dist[endX][endY]).append("\n");
        }

        System.out.print(sb); // 한 번에 출력
    }
}

