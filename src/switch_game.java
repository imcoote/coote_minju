/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n)
 * 메모리: 14616 kb
 * 시간: 116	 ms
 *******************************************************************************/
// 구현
import java.io.*;
import java.util.*;

public class switch_game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] switches = new int[n + 1]; // 1번부터 시작 (인덱스 1~n)

        // 스위치 상태 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for (int s = 0; s < studentCount; s++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 남학생: 배수 스위치 반전
                for (int i = num; i <= n; i += num) { // 받은 수 num의 배수 위치(num, 2·num, 3·num, …)를 모두 방문
                    switches[i] ^= 1; //^=(XOR) 1 → 비트 반전 ⇒ 토글(0 ↔ 1)
                }
            } else {
                // 여학생: 좌우 대칭 최대 범위 반전
                int left = num, right = num; // 중심
                while (left > 0 && right <= n && switches[left] == switches[right]) {
                    left--; // 대칭 범위 확장
                    right++;
                }
                // left+1 ~ right-1 까지 반전
                for (int i = left + 1; i < right; i++) {
                    switches[i] ^= 1;
                }
            }
        }

        // 출력 (20개씩 줄바꿈)
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}

