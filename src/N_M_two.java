/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(NCm)
 * 메모리: 15952 kb
 * 시간: 128 ms
 *******************************************************************************/
// 조합 문제
// 백트래킹
import java.io.*;
import java.util.*;

public class N_M_two {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 숫자 범위, m: 선택할 개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m]; // 현재 조합을 저장하는 배열

        combination(1, 0); // 시작 숫자 1부터하고 현재 깊이 0
    }

    // start: 조합의 숫자는 항상 오름차순으로 선택 -> 현재 숫자보다 큰 수부터 다음 선택 시작
    // dep: 현재 선택한 숫자의 개수
    static void combination(int start, int dep) {
        // 원하는 길이(m)에 도달했으면 현재 조합을 출력
        if (dep == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[dep] = i; // 현재 깊이에 i 저장

            // 조합에서는 (중복 없이) + (오름차순)으로 숫자를 선택해야 하므로 i+1부터 다시 시작
            combination(i + 1, dep + 1);
        }
    }
}


