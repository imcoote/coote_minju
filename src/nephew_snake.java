/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N × log(MaxLen))
 * 메모리: 115264 kb
 * 시간: 532 ms
 *******************************************************************************/
// 이진 탐색
// 1. mid = (left + right) / 2 를 하나의 후보 길이로 정함
// 2. 모든 과자를 이 길이로 잘라봤을 때 몇 조각 나오는지 계산
// 3. 조각 수 ≥ 조카 수(M) → 더 길게 자를 수 있는지 탐색
// 4. 조각 수 < M → 너무 길다 → 더 짧게 잘라야 함
import java.io.*;
import java.util.*;

public class nephew_snake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조카 수
        int n = Integer.parseInt(st.nextToken()); // 과자 수

        int[] snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        int max_len = 0;

        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if (snacks[i] > max_len) {
                max_len = snacks[i]; // 지금까지 본 과자 중 가장 긴 길이로 갱신
            }
        }

        int left = 1;
        int right = max_len;
        int result = 0;

        // 이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2;

            long count = 0;
            for (int len : snacks) {
                count += (len / mid); // mid 길이로 자르면 몇 조각 나오는지
            }

            if (count >= m) { // 조카 수보다 많이 만들 수 있으면(조각 수 > =  조카 수) 더 길게 잘라도 가능
                result = mid;     // 가능한 최대 길이 저장
                left = mid + 1;   // 더 긴 길이도 가능한지 확인하기 위해 +1
            } else {
                right = mid - 1;  // 너무 길어서 조각 수 부족 → 더 짧게 잘라야 함
            }
        }

        System.out.println(result);
    }
}

