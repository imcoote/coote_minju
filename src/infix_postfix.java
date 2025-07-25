/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(N)
 * 메모리: 14152 kb
 * 시간: 104	 ms
 *******************************************************************************/
// 스택사용
import java.io.*;
import java.util.*;

public class infix_postfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine(); // 수식 입력

        StringBuilder output = new StringBuilder(); // 후위 표기 결과 저장할 부분
        Stack<Character> stack = new Stack<>();  // 연산자 저장용 스택

        for (char ch : exp.toCharArray()) { // 문자 하나씩 처리
            if (Character.isLetter(ch)) {
                // 1. 피연산자면 바로 출력
                output.append(ch);
            } else if (ch == '(') {
                // 2. 여는 괄호: 스택에 push(연산자를 처리하기 전에 괄호 안 내용을 우선적으로 처리해야 하니까 스택에 보관)
                stack.push(ch);
            } else if (ch == ')') {
                // 3. 닫는 괄호: 닫는 괄호 )를 만나면 여는 괄호 '('가 나올 때까지 스택 안의 연산자를 출력
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            } else {
                // 4. 연산자: 우선순위가 낮은 연산자는 pop하고 현재 연산자 push
                // 현재 연산자보다 스택에 있는 연산자의 우선순위가 높거나 같으면 그 연산자를 먼저 출력해야 하므로
                // 스택에서 꺼내고 현재 연산자를 스택에 넣음
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 5. 남아있는 연산자 출력
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        System.out.println(output.toString());
    }

    // 연산자 우선순위
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}

