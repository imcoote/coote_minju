/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 14408 kb
 * 시간: 104 ms
 *******************************************************************************/
// 스택(Stack) 자료구조를 사용하는 문자열 파싱 + 계산 문제
import java.io.*;
import java.util.*;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();  // 한 줄 입력

        // stack은 괄호와 숫자 둘 다 담기 때문에 Object 타입 사용
        Stack<Object> stack = new Stack<>();
        // 유효하지 않은 괄호열을 탐지하면 isValid = false
        boolean isValid = true;

        for (char ch : input.toCharArray()) {
            // 여는 괄호는 스택에 추가
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                int tmp = 0; // 괄호 안에 포함된 숫자들의 합을 저장할 변수
                while (!stack.isEmpty()) {
                    Object top = stack.pop();
                    if (top instanceof Integer) {
                        // 괄호 안에 이미 계산된 값이 있는 경우 → 누적
                        tmp += (int) top;
                    } else if (ch == ')' && top.equals('(')) { // 소괄호
                        // tmp가 0 -> 빈 괄호 () → 값은 2
                        // temp > 0 -> 괄호 안에 값이 있는 경우 → 2 * 값
                        stack.push(tmp == 0 ? 2 : 2 * tmp);
                        break;
                    } else if (ch == ']' && top.equals('[')) { // 대괄호
                        // tmp가 0 -> 빈 괄호 [] → 값은 3
                        // tmp > 0 -> 괄호 안에 값이 있는 경우 → 3 * 값
                        stack.push(tmp == 0 ? 3 : 3 * tmp);
                        break;
                    } else {
                        // 괄호 짝이 맞지 않거나 잘못된 순서
                        isValid = false;
                        break;
                    }
                }

                if (!isValid || stack.isEmpty()) {
                    // → 잘못된 괄호열이므로 isValid를 false로 설정하고 반복 종료
                    isValid = false;
                    break;
                }
            }
        }

        int result = 0;
        if (isValid) {
            for (Object obj : stack) {
                if (obj instanceof Integer) {
                    // 스택 안에 숫자만 남아 있다면 모두 더해서 계산
                    result += (int) obj;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        System.out.println(isValid ? result : 0);
    }
}

