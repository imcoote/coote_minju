/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(t × L)
 * 메모리: 14368 kb
 * 시간: 112	 ms
 *******************************************************************************/
// 스택
// 여는 괄호가 나오면 스택에 넣고 닫는 괄호가 나오면 스택에서 꺼냄
import java.io.*;
import java.util.*;

public class 또다른_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 반복
        for (int i = 0; i < t; i++) {
            String line = br.readLine();  // 괄호 문자열 입력 부분
            Stack<Character> stack = new Stack<>();  // 괄호 짝 검사용 스택 생성
            boolean isValid = true;  // 유효한 괄호 문자열인지 표시

            // 문자열의 각 문자 순회
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);  // 여는 괄호는 스택에 추가
                } else if (ch == ')') {
                    // 닫는 괄호인데 스택이 비어 있으면 → 짝이 없음
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;  // 더 이상 검사할 필요 없음
                    }
                    stack.pop();  // 짝 맞는 여는 괄호 제거
                }
            }

            // 모든 문자를 처리했는데 스택에 여는 괄호가 남아 있으면 → 짝이 안 맞음
            if (!stack.isEmpty()) {
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}




