/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n * m)
 * 메모리: 56508 kb
 * 시간: 244 ms
 *******************************************************************************/
import java.util.*;
import java.io.*;

public class Surveillance {
    static int n, m;
    static int[][] office;
    static ArrayList<int[]> cctvs = new ArrayList<>();
    static int minBlindSpots = Integer.MAX_VALUE;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // CCTV 종류별 감시 가능한 방향 설정
    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},                          // 1번 CCTV (한 방향)
            {{0, 1}, {2, 3}},                              // 2번 CCTV (서로 반대 방향)
            {{0, 2}, {1, 2}, {1, 3}, {0, 3}},              // 3번 CCTV (L자 방향)
            {{0, 1, 2}, {0, 1, 3}, {1, 2, 3}, {0, 2, 3}},  // 4번 CCTV (세 방향)
            {{0, 1, 2, 3}}                                 // 5번 CCTV (네 방향 모두)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        office = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= office[i][j] && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        dfs(0, office);
        System.out.println(minBlindSpots);
    }

    public static void dfs(int depth, int[][] office) {
        if (depth == cctvs.size()) {
            minBlindSpots = Math.min(minBlindSpots, countBlindSpots(office));
            return;
        }

        int x = cctvs.get(depth)[0];
        int y = cctvs.get(depth)[1];
        int type = cctvs.get(depth)[2];

        for (int[] direction : directions[type]) {
            int[][] tempOffice = deepCopy(office);
            markArea(x, y, direction, tempOffice);
            dfs(depth + 1, tempOffice);
        }
    }

    public static void markArea(int x, int y, int[] direction, int[][] office) {
        for (int d : direction) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || office[nx][ny] == 6) break;
                if (office[nx][ny] == 0) office[nx][ny] = -1;
            }
        }
    }

    public static int countBlindSpots(int[][] office) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[0].length);
        }
        return copy;
    }
}
