/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n²)
 * 메모리: 25740 kb
 * 시간: 244	 ms
 *******************************************************************************/
// dp
import java.io.*;
import java.util.*;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        // 삼각형 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Bottom-Up DP: 아래에서부터 위로 누적합 계산
        for (int i = n - 2; i >= 0; i--) { // 위에서부터 말고 아래에서 위로
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        // 맨 꼭대기 값이 최대 합
        System.out.println(triangle[0][0]);
    }
}

