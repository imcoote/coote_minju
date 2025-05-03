/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n log n))
 * 메모리: 16848 kb
 * 시간: 16 ms
 *******************************************************************************/
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class sensors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 센서 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 집중국 개수 입력
        int a = Integer.parseInt(br.readLine());

        // 좌표값들 입력 -> arr에 저장
        // if [1, 6, 9, 3, 6, 7]
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 센서 개수가 집중국 개수보다 작거나 같으면 모든 센서 커버 가능
        if (a >= n) {
            System.out.println(0);
            return;
        }

        // 센서 좌표 정렬(.sort())
        // [1, 6, 9, 3, 6, 7]->[1, 3, 6, 6, 7, 9]
        Arrays.sort(arr);

        // 인접 센서들 간 거리 차이 저장
        // 센서 간 거리-> [2, 3, 0, 1, 2]
        // (1-3, 3-6, 6-6, 6-7, 7-9)
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = arr[i + 1] - arr[i];
        }

        // 거리 차이 내림차순 정렬
        // [2, 3, 0, 1, 2]->[3, 2, 2, 1, 0]
        Arrays.sort(diffs);

        // 가장 큰 값 (q - 1)개를 제거 → 남은 것들의 합이 정답
        // 2 + 2 + 1 + 0 = 5
        int sum = 0;
        for (int i = 0; i < n - a; i++) {
            sum += diffs[i];
        }

        System.out.println(sum);
    }
}

