/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(n²)
 * 메모리: 21008 kb
 * 시간: 240 ms
 *******************************************************************************/
import java.util.*;

public class box {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxes = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 최소 1개의 상자는 혼자라도 가능

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }

        System.out.println(result);
    }
}

