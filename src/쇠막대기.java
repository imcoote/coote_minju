/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 16392 kb
 * 시간: 172	 ms
 *******************************************************************************/
// 스택
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        // 입력을 BufferedReader로 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 괄호 문자열 한 줄

        // stack: 열린 괄호 '('들을 담아두는 용도
        Stack<Character> stack = new Stack<>();
        int result = 0;

        // 문자열 순회
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            // 스택에 푸시 → 새 막대기 시작 or 레이저 왼쪽 괄호
            if (cur == '(') {
                stack.push(cur);
            } else { // ')'인 경우
                stack.pop(); // '(' 하나 제거

                // 경우 1: 레이저인 경우 ("()") (현재 문자 )의 바로 앞 문자가 '('이면)
                if (input.charAt(i - 1) == '(') {
                    // 레이저-> 현재 열린 막대기 수만큼 조각냄
                    result += stack.size();
                } else {
                    // 경우 2: 쇠막대기 끝-> 조각 1개
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}

