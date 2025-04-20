/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 20076 kb
 * 시간: 264 ms
 *******************************************************************************/
import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class stack {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stackInt = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String line = br.readLine(); // 한 줄 입력 받기
            String[] parts = line.split(" "); // 공백 기준 나눔

            String str = parts[0];

            if (str.equals("push")){
                int num = Integer.parseInt(parts[1]);
                stackInt.push(num);

            } else if (str.equals("pop")) {
                if (stackInt.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stackInt.pop());
                }

            } else if (str.equals("top")) {
                if (stackInt.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stackInt.peek());
                }

            } else if (str.equals("size")) {
                System.out.println(stackInt.size());

            } else if (str.equals("empty")) {
                if (stackInt.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}

