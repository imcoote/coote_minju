/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 20332 kb
 * 시간: 288 ms
 *******************************************************************************/
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class queue {
    public static void main(String[] args) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String line = br.readLine(); // 한 줄 입력 받기
            String[] parts = line.split(" "); // 공백 기준 나눔

            String str = parts[0];

            if (str.equals("push")){
                int num = Integer.parseInt(parts[1]);
                queue.offer(num);

            } else if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }

            } else if (str.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }

            } else if (str.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(((LinkedList<Integer>) queue).getLast());
                }

            } else if (str.equals("size")) {
                System.out.println(queue.size());

            } else if (str.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

        }
    }
}

