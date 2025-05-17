/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(kC6)
 * 메모리: 14248 kb
 * 시간: 112 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class lotto {
    static int k;
    static int[] s;
    static int[] combination = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isFirstOutput = true;

        while (true) {
            String line = br.readLine();

            //문자열 값 비교(equals)
            if (line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            s = new int[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            if (!isFirstOutput) sb.append("\n"); // 테스트 케이스 사이 빈 줄
            isFirstOutput = false;

            dfs(0, 0);
        }

        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(combination[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            combination[depth] = s[i];
            dfs(i + 1, depth + 1);
        }
    }
}

