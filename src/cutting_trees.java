/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N × log₂(max 높이))
 * 메모리: 119348kb
 * 시간: 492 ms
 *******************************************************************************/
// 이진탐색
// low = 0, high = max(나무 높이)
// mid = (low + high) / 2
// getWood(mid)가 M 이상이면 → mid는 가능한 높이일 수도 있음 → 더 높은 값 탐색 (low = mid + 1)
// M 미만이면 → 너무 높게 잘랐음 → 낮은 값 탐색 (high = mid - 1)
// 마지막에 조건을 만족하는 H 중 최댓값 반환
import java.io.*;
import java.util.*;

public class cutting_trees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 개수
        long M = Long.parseLong(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N]; // 각 나무의 높이
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i]; // 가장 높은 나무를 여기서 찾이줌
            }
        }

        int low = 0;
        int high = max;
        int result = 0; // 조건을 만족하는 절단기 높이 중 최댓값 저장

        while (low <= high) {
            int mid = (low + high) / 2; // 절단기 높이 후보

            long total = 0;
            for (int h : trees) {
                if (h > mid) {
                    total += (h - mid); // mid보다 큰 나무만 잘라야함
                }
            }

            if (total >= M) {
                result = mid;      // 조건을 만족하므로 정답 후보
                low = mid + 1;     // 더 높은 절단값 시도 ->더 적게 잘라야함 -> 환경에 안좋음
            } else {
                high = mid - 1;    // 너무 높게 잘랐으므로 낮추기 -> 절단값 낮춤
            }
        }

        System.out.println(result);
    }
}

