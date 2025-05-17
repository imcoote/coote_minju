/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N log N)
 * 메모리: 25872 kb
 * 시간: 328 ms
 *******************************************************************************/
// 우선순위 큐, 최소 힙
import java.io.*;
import java.util.*;

public class card_sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 최소 힙 (우선순위 큐)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 카드 묶음의 크기들을 우선순위 큐에 삽입
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 총 비교 횟수 누적 변수
        int total_cost = 0;

        // 큐에 카드 묶음이 2개 이상일 때만 합치기 진행
        while (pq.size() > 1) {
            // 가장 작은 두 묶음을 꺼냄
            int first = pq.poll();
            int second = pq.poll();

            // 두 묶음을 합칠 때 드는 비교 횟수
            int sum = first + second;

            // 누적 비교 횟수에 추가
            total_cost += sum;
            pq.add(sum); // 합친 묶음을 다시 삽입
        }

        System.out.println(total_cost);
    }
}

