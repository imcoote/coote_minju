/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N + E)
 * 메모리: 14316 kb
 * 시간: 104 ms
 *******************************************************************************/
// 1번 칸에서 시작해서 100번 칸까지 가는 데 필요한 주사위 굴림 횟수의 최솟값은?
// 사다리(이득)와 뱀(손해)-> 강제 이동 요소
import java.io.*;
import java.util.*;

public class snakes_ladders {

    // 1~100번 칸까지 이동 정보를 저장할 배열
    static int[] board = new int[101];

    // 해당 칸을 이미 방문했는지 체크하는 배열 (중복 탐색 방지)
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력용

        // 첫 줄: 사다리 수 N, 뱀 수 M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        // 보드 초기화: 기본적으로 각 칸은 자기 자신으로 이동
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        // 사다리 입력 처리: from → to 로 즉시 이동
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        // 뱀 입력 처리: from → to 로 즉시 이동
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        // BFS로 최소 이동 횟수 계산 후 출력
        sb.append(bfs());
        System.out.println(sb);
    }

    // 최소 이동 횟수 구하는 BFS 함수
    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 시작: 1번 칸에서 시작, 주사위 굴린 횟수는 0
        queue.add(new int[]{1, 0});
        visited[1] = true;

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int pos = now[0]; // 현재 위치
            int cnt = now[1]; // 지금까지 굴린 주사위 횟수

            // 목표 도착: 100번 칸
            if (pos == 100) return cnt;

            // 주사위 1~6을 굴려볼 수 있음
            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;

                // 100번 칸을 넘지 않으면서 아직 안 가본 칸이라면
                if (next <= 100 && !visited[board[next]]) {
                    visited[board[next]] = true; // 방문 처리
                    queue.add(new int[]{board[next], cnt + 1}); // 다음 칸 + 주사위 횟수 +1
                }
            }
        }

        return -1; // 문제 조건상 도달 불가능은 없음 (이 줄은 사실상 실행 안 됨)
    }
}


