/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(K × log(maxLen))
 * 메모리: 17516 kb
 * 시간: 164	 ms
 *******************************************************************************/
// 이분팀색
import java.io.*;
import java.util.*;

public class lan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 기존 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        long[] cables = new long[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            if (cables[i] > maxLen) {
                maxLen = cables[i]; //이게 자를 수 있는 상한선
            }
        }

        // 이분 탐색
        long left = 1; // 자를 수 있는 최소 길이
        long right = maxLen; // 자를 수 있는 최대 길이

        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 시도해볼 랜선 길이
            long count = 0;

            for (long cable : cables) {
                count += cable / mid; // mid 길이로 잘랐을 때 몇 개 나오는지 계산
            }

            if (count >= N) {
                result = mid;      // 일단 가능한 길이니까 저장
                left = mid + 1;    // 더 길게 잘라도 가능할지 시도
            } else {
                right = mid - 1;   // 너무 길어서 개수 부족 → 줄이기
            }
        }

        System.out.println(result);
    }
}

