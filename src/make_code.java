/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(CCL × L)
 * 메모리: 15940 kb
 * 시간: 116 ms
 *******************************************************************************/
import java.util.*;
import java.io.*;

public class make_code {
    // 전역 변수 선언
    static int L, C;
    static char[] chars;
    static StringBuilder sb = new StringBuilder();

    // final: 값을 재할당하지 못하도록 고정
    static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lc = br.readLine().split(" ");
        L = Integer.parseInt(lc[0]);
        C = Integer.parseInt(lc[1]);

        // 알파벳 입력 받기
        chars = new char[C];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            chars[i] = input[i].charAt(0);
        }

        Arrays.sort(chars); // 사전순으로 정렬, 오름차순 정렬

        // 조합 생성 시작
        dfs(0, 0, new StringBuilder());

        System.out.print(sb);
    }

    static void dfs(int depth, int index, StringBuilder password) {
        if (depth == L) {
            if (isValid(password.toString())) {
                sb.append(password).append('\n'); // 조건 만족 -> 결과에 삽입
            }
            return;
        }

        for (int i = index; i < C; i++) {
            password.append(chars[i]); // 알파벳 추가
            dfs(depth + 1, i + 1, password); // 재귀 호출
            password.deleteCharAt(password.length() - 1); // 백트래킹
        }
    }

    // 조건 검증 함수
    // 조건을 만족하면 true 아니면 false
    static boolean isValid(String pw) {
        int vowel_cnt = 0; // 모음 수
        int consonant_cnt = 0; // 자음 수
        for (char c : pw.toCharArray()) {
            if (vowels.contains(c)) vowel_cnt++;
            else consonant_cnt++;
        }
        return vowel_cnt >= 1 && consonant_cnt >= 2;
    }
}

