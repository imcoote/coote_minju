/*******************************************************************************
 * 소요시간: 45분
 * 시간복잡도: O(H × N²)
 * 메모리: 55280 kb
 * 시간: 276 ms
 *******************************************************************************/
/**
 1. 이중리스트를 입력받아서 이쁘게 만듬(이떄 제일 작은 높은 큰 높이를 구함)
 2. 일단 제일 작은 높이 부터 시작, 이때 안전구역을 구함. (bfs사용)
 3. 그 다음 1++로 높이가 커져나가고 계속 안전구역 개수를 구함
 4. 제일작은 높이부터 큰 높이까지 안전구역 개수를 구함
 5. 제일 개수가 많은 안전구역 출력
 **/

import java.io.*;
import java.util.*;

public class safe_zone {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 입력 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int minHeight = 101;
        int maxHeight = 0;

        // 1. 높이 정보 입력 + 최소/최대 높이 구하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeZone = 0;

        // 2. 최소 높이부터 최대 높이까지 반복
        for (int h = minHeight - 1; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int safeCount = 0;

            // 3. 현재 높이 h일 때 안전 구역 BFS 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        safeCount++;
                    }
                }
            }

            // 4. 최대 안전 구역 개수 저장
            maxSafeZone = Math.max(maxSafeZone, safeCount);
        }

        // 5. 출력
        System.out.println(maxSafeZone);
    }

    // bfs
    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] > h) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}


