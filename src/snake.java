/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(S × L)
 * 메모리: 14924 kb
 * 시간: 124 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class snake {
    static int N;
    static int[][] board;
    static Deque<int[]> snake = new LinkedList<>();
    static Map<Integer, Character> dirChanges = new HashMap<>();
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        board = new int[N][N]; // 0: 빈칸, 1: 사과

        // 사과 위치
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        // 방향 전환 정보
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirChanges.put(time, dir);
        }

        // 게임 시작
        int time = 0;
        int x = 0, y = 0;
        int dir = 0;
        snake.add(new int[]{x, y});

        while (true) {
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽에 부딪힘
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;

            // 자기 몸에 부딪힘
            for (int[] part : snake) {
                if (part[0] == nx && part[1] == ny) {
                    System.out.println(time);
                    return;
                }
            }

            // 이동
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 먹음
                snake.addFirst(new int[]{nx, ny}); // 머리 늘림
            } else {
                snake.addFirst(new int[]{nx, ny}); // 머리 늘림
                snake.removeLast(); // 꼬리 줄임
            }

            // 방향 전환
            if (dirChanges.containsKey(time)) {
                char turn = dirChanges.get(time);
                if (turn == 'D') dir = (dir + 1) % 4;
                else if (turn == 'L') dir = (dir + 3) % 4;
            }

            x = nx;
            y = ny;
        }

        System.out.println(time);
    }
}


