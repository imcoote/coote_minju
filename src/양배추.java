/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(T × m × n) 테스트케이스 T개가 반복될 때 전체 시간
 * 메모리: 17872 kb
 * 시간: 156 ms
 *******************************************************************************/
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 양배추 {
    static class Node {
        int x, y; // 좌표

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // BFS 함수
    static void bfs(int startX, int startY, int[][] map, boolean[][] visited, int m, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY)); // 큐에 현재 시작 위치 넣어줌
        visited[startX][startY] = true; // 방문 여부를 확인하기 위해 m * n 크기만큼 배열을 만들어 false로 채워줌 방문할 시 false->true

        int[] dx = {-1, 1, 0, 0}; // 상, 하
        int[] dy = {0, 0, -1, 1}; // 좌, 우

        while (!queue.isEmpty()) { //큐가 빌 때까지
            Node current = queue.poll(); // 큐에서 하나 꺼내줌
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    // 아직 방문하지 않았고(!visited[nx][ny]:true), 양배추가 있는 곳(map[nx][ny] == 1)이면 큐에 추가
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 입력

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" "); //한 줄에 여러 숫자 입력받기
            int n = Integer.parseInt(input[0]); // 세로
            int m = Integer.parseInt(input[1]); // 가로
            int k = Integer.parseInt(input[2]); // 배추 위치 개수

            int[][] map = new int[m][n]; // 배추밭
            boolean[][] visited = new boolean[m][n]; // 방문 여부를 저장하는 2차원 배열

            for (int i = 0; i < k; i++) {
                String[] tmp = br.readLine().split(" "); // 배추가 심겨진 곳 입력받음 -> "0->1"
                int x = Integer.parseInt(tmp[0]); // x축
                int y = Integer.parseInt(tmp[1]); // y축
                map[y][x] = 1; // 0(배추 없는 곳) -> 1(배추 있는 곳)
            }

            int cnt = 0; // 배추 군집 개수 담을 변수
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 아직 안가봤고(!visited[i][j]) 배추가 있는 곳(map[i][j] == 1)이면 상하좌우 탐색
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j, map, visited, m, n);
                        // BFS탐색이 끝날 시 군집 개수 + 1
                        cnt++;
                    }
                }
            }
            System.out.println(cnt); // 군집 개수 프린트
        }
    }
}
