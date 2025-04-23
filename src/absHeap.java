/*******************************************************************************
 * 소요시간: 45분
 * 시간복잡도: O(n log n)
 * 메모리: 30080 kb
 * 시간: 540	 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class absHeap {
    public static void main(String[] args) throws IOException {

        // 절댓값 기준 정렬 + 절댓값이 같다면 원래 수가 작은 값 우선
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) {
                        return a - b;
                    }
                    return absA - absB;
                }
        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}



