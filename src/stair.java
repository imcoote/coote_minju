/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n)
 * 메모리: 14188 kb
 * 시간: 104 ms
 *******************************************************************************/
// dp문제
import java.io.*;

public class stair {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];

        // n이 1일 때 예외 처리
        if (n == 1) {
            System.out.println(score[0]);
            return;
        }

        dp[0] = score[0]; // 첫 계단 밟은 점수
        dp[1] = Math.max(dp[1], dp[0] + score[1]); // 두 번째 계단까지 고려했을 시
        if (n >= 3) {
            dp[2] = Math.max(score[0] + score[2], score[1] + score[2]); // 세 번째 계단까지 고려했을 시
        }

        for (int i = 3; i < n; i ++){
            // 마지막 계단은 반드시 밟아야 함->
            // i번째 계단을 밟는 경우만 고려하여 최대 점수를 계산함
            dp[i] = Math.max(
                    dp[i-2] + score[i],              // 1. 한 칸 건너뛰고 현재 계단 밟기
                    dp[i-3] + score[i-1] + score[i]  // 2. 두 칸 건너뛰고 2연속으로 오기
            );
        }
        int result = dp[n-1];

        System.out.println(result);
    }
}
