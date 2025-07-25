/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(t)
 * 메모리: 14084 kb
 * 시간: 108	 ms
 *******************************************************************************/
// dp
// [정수 n을 1, 2, 3의 합으로 나타내는 경우의 수]

// 점화식:dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]
//마지막에 1을 붙이면 → dp[n-1] -> n-1에 1을 더하는 경우
//마지막에 2를 붙이면 → dp[n-2] -> n-2에 2를 더하는 경우
//마지막에 3을 붙이면 → dp[n-3] -> n-3에 3을 더하는 경우의 수를 더한 경우와 같다
//즉 -> n을 만들기 위해 마지막에 어떤 수(1, 2, 3)를 붙이느냐에 따라 경우의 수가 나뉨
import java.io.*;

public class plus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // n은 11보다 작다 → 최대 10까지 미리 dp 계산
        int[] dp = new int[11];
        // 초기값 설정
        dp[1] = 1;  // (1)
        dp[2] = 2;  // (1+1), (2)
        dp[3] = 4;  // (1+1+1), (1+2), (2+1), (3)

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}

