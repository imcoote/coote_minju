/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n)
 * 메모리: 110864 kb
 * 시간: 608 ms
 *******************************************************************************/
// dp 문제
import java.io.*;
import java.util.*;

public class sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 열의 개수 (스티커 개수는 2n개)

            int[][] sticker = new int[2][n + 1]; // 1-based index 사용
            int[][] dp = new int[2][n + 1];      // DP 배열 (dp[0][i], dp[1][i])

            // 스티커 점수 입력
            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= n; col++) {
                    sticker[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기 조건 설정
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            // 점화식 적용
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            // 마지막 열에서 위/아래 중 최대값 출력
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }

        System.out.print(sb.toString());
    }
}

