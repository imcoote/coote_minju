/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(n * m)
 * 메모리: 18832 kb
 * 시간: 216 ms
 *******************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Area {
    static int M, N, K;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        paper = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    paper[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 0 && !visited[i][j]) { // 빈 영역이고 방문하지 않은 경우
                    int areaSize = dfs(i, j);
                    areas.add(areaSize);
                }
            }
        }

        Collections.sort(areas); // 오름차순 정렬
        System.out.println(areas.size()); // 영역의 개수
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; // 현재 칸 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (paper[nx][ny] == 0 && !visited[nx][ny]) {
                    area += dfs(nx, ny);
                }
            }
        }

        return area;
    }
}
