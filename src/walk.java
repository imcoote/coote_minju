/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(1)
 * 메모리: 14216 kb
 * 시간: 100 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class walk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]); // 21억이 넘어서 int 대신 long
        long Y = Long.parseLong(input[1]);
        long W = Long.parseLong(input[2]);
        long S = Long.parseLong(input[3]);

        long sum = 0;

        // 1칸씩 걷는 게 무조건 싸면 그냥 걷기만
        if (2 * W <= S) {
            sum = (X + Y) * W;
        }
        // 대각선이 더 싸거나 같을 때
        else if (S <= W) {
            if ((X + Y) % 2 == 0) { // 두 좌표 합이 짝수면 대각선만
                sum = Math.max(X, Y) * S;
            } else { // 홀수면 대각선 + 걷기
                sum = (Math.max(X, Y) - 1) * S + W;
            }
        }
        // 섞어서 가는 게 이득일 때
        else {
            long min = Math.min(X, Y); // 둘 중 작은 거 만큼 대각선
            long max = Math.max(X, Y); // 남은 만큼 걷기
            sum = min * S + (max - min) * W;
        }

        System.out.println(sum);
    }
}

