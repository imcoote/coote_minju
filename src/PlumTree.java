/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(a×max_cnt)
 * 메모리: 18064 kb
 * 시간: 204 ms
 *******************************************************************************/
import java.util.Scanner;

public class PlumTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 총 시간
        int W = sc.nextInt(); // 최대 이동 횟수
        int[] plums = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            plums[i] = sc.nextInt();
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 현재 자두가 떨어지는 나무
                int curTree = plums[t];

                // 이동하지 않는 경우
                if (w == 0) {
                    dp[t][w] = dp[t - 1][w] + (curTree == 1 ? 1 : 0);
                } else {
                    // 이동하지 않는 경우 vs 이동하는 경우
                    dp[t][w] = Math.max(
                            dp[t - 1][w] + (curTree == (w % 2 == 0 ? 1 : 2) ? 1 : 0),
                            dp[t - 1][w - 1] + (curTree == (w % 2 == 0 ? 1 : 2) ? 1 : 0)
                    );
                }
            }
        }

        int result = 0;
        for (int w = 0; w <= W; w++) {
            result = Math.max(result, dp[T][w]);
        }

        System.out.println(result);
    }
}

