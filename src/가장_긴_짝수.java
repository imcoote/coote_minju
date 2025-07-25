/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(n)
 * 메모리: 91304 kb
 * 시간: 424 ms
 *******************************************************************************/
// 최대 K개의 홀수를 제거해서 만들 수 있는 가장 긴 연속된 짝수 수열의 길이를 구하는 문제
// 슬라이딩 윈도우(투 포인터)

// 수열을 오른쪽으로 훑어가며 홀수가 K개를 넘지 않게 관리하면서
// 짝수만 남는 연속 부분 수열의 길이를 최대한 길게 만듬
import java.io.*;
import java.util.*;

public class 가장_긴_짝수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] S = new int[n]; // 수열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0; // 윈도우 왼쪽 포인터
        int oddCnt = 0;  // 현재 윈도우 내의 홀수 개수
        int max_len = 0; // 최대 짝수 부분 수열 길이

        for (int right = 0; right < n; right++) {
            if (S[right] % 2 != 0) {
                oddCnt++; // 오른쪽으로 확장할 때 홀수면 카운트 증가++
            }

            // 홀수 개수가 K를 초과하면 조건을 만족하지 않으므로
            // left 포인터를 오른쪽으로 옮겨가며 홀수 개수를 줄임
            while (oddCnt > k) {
                if (S[left] % 2 != 0) {
                    oddCnt--; // 빠지는 값이 홀수면 홀수 개수 줄이기
                }
                left++; // left를 오른쪽으로 한 칸 이동
            }

            // 현재 윈도우에서 짝수의 개수 = 전체 길이 - 홀수 개수
            max_len = Math.max(max_len, right - left + 1 - oddCnt);
        }
        System.out.println(max_len);
    }
}

