/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(n log n)
 * 메모리: 33580 kb
 * 시간: 772 ms
 *******************************************************************************/
// 우선순위 큐
import java.io.IOException;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

//항상 큰 값이 먼저 나옴
public class maxHeap {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine()); // 총 입력받을 숫자의 개수


        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            // 숫자 0이 들어올 시 우선순위에 따라 출력해야 함
            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(0); // 힙에 아무것도 없으면 0 출력
                }else{
                    System.out.println(maxHeap.poll()); // 현재 힙에서 제일 큰 숫자 출력
                }
            } else {
                maxHeap.add(num); // 힙에 숫자 넣기
            }
        }
    }
}

