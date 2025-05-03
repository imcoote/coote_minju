/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(M × N)
 * 메모리: 14324 kb
 * 시간: 104 ms
 *******************************************************************************/
// 이건 덱을 써야함 ㅇㅇ
import java.io.*;
import java.util.*;

public class rotating_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N: 큐 크기, M: 뽑을 원소 수
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        Deque<Integer> deque = new LinkedList<>(); // 양방향 큐

        // 1 ~ N 큐에 넣기
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        String[] targets = br.readLine().split(" "); // 뽑을 원소 리스트
        int cnt = 0; // 이동 연산 횟수

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(targets[i]);

            // 현재 target이 큐에서 몇 번째 있는지 찾기
            int idx = 0;
            for (int val : deque) {
                if (val == target) break;
                idx++;
            }

            int left = idx; // 왼쪽 이동 횟수
            int right = deque.size() - idx; // 오른쪽 이동 횟수

            // 더 짧은 쪽으로 회전
            if (left <= right) {
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst()); // 왼쪽 이동
                    cnt++;
                }
            } else {
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast()); // 오른쪽 이동
                    cnt++;
                }
            }

            deque.pollFirst(); // 맨 앞 요소 꺼내기
        }

        sb.append(cnt).append('\n'); // 결과 저장
        System.out.print(sb); // 출력
    }
}
