/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(m × log n)
 * 메모리: 22128 kb
 * 시간: 284 ms
 ***************************************************************************/
import java.util.*;

public class card_merging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 카드 개수
        int m = sc.nextInt(); // 합체 횟수

        // 최소 힙(오름차순 정렬) 우선순위 큐 생성
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 초기 카드 숫자들을 우선순위 큐에 추가
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }

        // 가장 작은 두 수를 합치는 작업을 m번 수행
        for (int i = 0; i < m; i++) {
            long x = pq.poll(); // 가장 작은 값 제거
            long y = pq.poll(); // 두 번째로 작은 값 제거
            long sum = x + y; // 두 카드를 합침
            pq.add(sum); // 합친 결과를 다시 두 번 추가
            pq.add(sum);
        }

        long total = 0;

        // 우선순위 큐에 남은 카드 값을 모두 더함
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}

