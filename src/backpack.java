/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(N * k)
 * 메모리: 53808 kb
 * 시간: 176 ms
 *******************************************************************************/
// dp문제
import java.io.*;
import java.util.*;

public class backpack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 물품 수 N, 배낭 최대 무게 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 무게와 가치 배열
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        // N개의 줄 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken()); // 무게
            value[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        // i번째 물건까지 사용했을 때, 무게 w에서의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 안 넣을 경우: dp[i-1][w]
        // 넣을 경우: dp[i-1][w - weight[i]] + value[i]
        // → 이 둘 중 더 큰  가치 선택
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (weight[i] > w) {
                    // 현재 물건 담기 X -> 이전 값 유지
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 현재 물건 담기 O -> 담을지 말지 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}

