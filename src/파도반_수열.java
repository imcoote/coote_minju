/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(T × N)
 * 메모리: 14236 kb
 * 시간: 108 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 파도반_수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int test_case = 0; test_case < T; test_case++) {
            int num = Integer.parseInt(br.readLine()); // 각 테스트 케이스마다 계산할 수열의 항 번호 입력

            // 파도반 수열 값을 저장할 배열(arr)
            // 최소 6칸 확보 (인덱스 5까지 필요), 입력값이 더 크면 그만큼 할당
            long[] arr = new long[Math.max(6, num + 1)];

            // 초기값 세팅 (문제에서 주어진 조건)
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;
            arr[5] = 2;

            // 점화식을 이용해 num 번째 항까지 수열 계산
            // 점화식: P(N) = P(N-1) + P(N-5)
            if (num >= 6) {
                for (int i = 6; i <= num; i++) {
                    arr[i] = arr[i - 1] + arr[i - 5];
                }
            }

            System.out.println(arr[num]);
        }
    }
}
