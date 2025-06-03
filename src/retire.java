/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 14228 kb
 * 시간: 104 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class retire {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 수익
        int[] dp = new int[N + 2]; // i일까지 벌 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 오늘 상담을 안 하면, 내일까지 수익은 그대로
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 오늘 상담을 할 수 있으면 (퇴사 전까지 끝나는 경우)
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}


