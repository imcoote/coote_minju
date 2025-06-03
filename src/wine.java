/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n)
 * 메모리: 14912 kb
 * 시간: 132 ms
 *******************************************************************************/
//dp[i] = max(
//        dp[i - 1], // i번째 안 마심
//        dp[i - 2] + wine[i], // i번째만 마심
//        dp[i - 3] + wine[i - 1] + wine[i] // i-1, i 마심
//        )

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class wine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        // 초기 조건
        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}


