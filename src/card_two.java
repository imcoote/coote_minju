/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(N)
 * 메모리: 37008 kb
 * 시간: 172 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class card_two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N: 큐 크기
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);

        Deque<Integer> deque = new ArrayDeque<>();

        // 1 ~ N 큐에 넣기
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {

            // 1단 맨 첫번째을 빼
            deque.removeFirst();
            // 그다름 맨 앞에 있는거를 맨 뒤로 보내
            int val = deque.removeFirst();
            deque.addLast(val);
        }

        sb.append(deque.removeFirst());// 마지막에 남은 숫자 출력
        System.out.println(sb);

    }
}