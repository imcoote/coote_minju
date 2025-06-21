/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(N)
 * 메모리: 24820 kb
 * 시간: 304 ms
 *******************************************************************************/
// 투 포인터
import java.io.*;
import java.util.*;

public class liquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 용액 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        // 배열에 입력 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 투 포인터 초기화
        int start = 0; // start: 가장 작은 값 (왼쪽 끝)
        int end = N - 1; // end: 가장 큰 값 (오른쪽 끝)

        int minAbs = Integer.MAX_VALUE; // 지금까지 찾은 최소 절댓값
        int result = 0; // 그때의 실제 합 저장할 곳

        while (start < end) {
            int sum = arr[start] + arr[end]; // // 두 용액을 합치는 부분

            // 절댓값이 더 작으면 갱신
            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                result = sum;
            }

            // 합이 0보다 크면 → 값을 줄이기 위해 end(큰 수) 줄이기
            if (sum > 0) {
                end--;
            }
            // 합이 0보다 작으면 → 값을 키우기 위해 start(작은 수) 증가
            else if (sum < 0) {
                start++;
            }
            // 딱 0이면 가장 가까운 값이므로 종료
            else {
                break;
            }
        }

        System.out.println(result);
    }
}

