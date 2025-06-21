/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n)
 * 메모리: 21180 kb
 * 시간: 180 ms
 *******************************************************************************/
import java.util.Scanner;

public class zoo {
    static final int MOD = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        int result = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
        System.out.println(result);
    }
}

