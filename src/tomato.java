/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(M × N × H)
 * 메모리: 145152 kb
 * 시간: 816 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

// 3차원 BFS를 이용한 문제
public class tomato {

    // 하나의 칸의 좌표 정보를 담는 클래스 (z: 층, y: 행, x: 열)
    static class Node {
        int z, y, x;

        Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int M = Integer.parseInt(size[0]); // 가로(열) 길이
        int N = Integer.parseInt(size[1]); // 세로(행) 길이
        int H = Integer.parseInt(size[2]); // 높이(층) 수

        int[][][] box = new int[H][N][M];      // 토마토 상태 저장 배열
        int[][][] days = new int[H][N][M];     // 익는 데 걸린 날짜 저장 배열

        // 상자 상태 입력 받기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] row = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(row[m]);
                }
            }
        }

        // BFS 큐 생성 및 초기 익은 토마토 위치 삽입
        Queue<Node> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 1) {
                        queue.offer(new Node(h, n, m));
                    }
                }
            }
        }

        // 위, 아래, 앞, 뒤, 왼쪽, 오른쪽 6방향 정의 (3차원)
        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dx = {0, 0, 0, 0, -1, 1};

        // BFS 탐색 수행
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nz = curr.z + dz[i];
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                // 범위 내에 있고 익지 않은 토마토가 있는 경우
                if (0 <= nz && nz < H && 0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1; // 익음 처리
                        days[nz][ny][nx] = days[curr.z][curr.y][curr.x] + 1; // 날짜 저장
                        queue.offer(new Node(nz, ny, nx));
                    }
                }
            }
        }

        // 결과 계산
        // 모든 토마토가 익었는지 확인하며 최대 일수 계산
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1); // 익지 않은 토마토 존재
                        return;
                    }
                    max = Math.max(max, days[h][n][m]); // 최대 날짜 갱신 파트
                }
            }
        }
        System.out.println(max); // 최소 출력
    }
}
