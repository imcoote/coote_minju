/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N × log(maxRequest))
 * 메모리: 30376 kb
 * 시간: 360 ms
 *******************************************************************************/
//돈이 남는다 (예산 안 넘는다)→ 더 줘도 되니까 → 상한선(mid)을 올려본다 → 오른쪽으로 범위 확장
//돈이 부족하다 (예산 초과)→ 너무 많이 주고 있으니까 → 상한선(mid)을 줄인다 → 왼쪽으로 범위 축소
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class budgets {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄, 지방 개수
        int n = Integer.parseInt(br.readLine());
        int[] requests = new int[n];
        int maxRequest = 0;

        // 두 번째 줄, 예산 요청들 입력 (공백으로 구분)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            if (requests[i] > maxRequest) {
                maxRequest = requests[i];
            }
        }

        // 세 번째 줄, 총 예산 입력
        int totalBudget = Integer.parseInt(br.readLine());

        // 이분 탐색 범위 설정
        int left = 0;
        int right = maxRequest;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid를 상한액으로 설정했을 때 총 예산 계산
            int sum = 0;
            for (int req : requests) {
                sum += Math.min(req, mid);
            }

            if (sum <= totalBudget) {
                answer = mid;      // 가능한 상한액 후보 저장
                left = mid + 1;    // 더 큰 값도 가능하니 오른쪽 탐색
            } else {
                right = mid - 1;   // 초과했으니 줄여야 함
            }
        }

        System.out.println(answer);
    }
}

