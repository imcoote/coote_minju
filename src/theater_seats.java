/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N)
 * 메모리: 14060 kb
 * 시간: 100 ms
 *******************************************************************************/
// dp문제
// 피보나치 수열로 계산
// f[n] = f[n - 1] + f[n - 2]
import java.io.*;
import java.util.*;

public class theater_seats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 좌석 수
        int M = Integer.parseInt(br.readLine()); // VIP 수

        // VIP 좌석 저장
        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        // f[i] -> i개의 좌석에 가능한 배치 수 (피보나치)
        int[] f = new int[41];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= 40; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int result = 1; // 최종 경우의 수 곱셈 결과
        int last = 0; // 마지막 VIP 좌석 위치

        for (int i = 0; i < M; i++) {
            int len = vip[i] - last - 1; // VIP 좌석 사이 구간 길이
            result *= f[len]; // 그 구간에 가능한 배치 수 곱하기
            last = vip[i]; // 현재 VIP 좌석 이후로 이동
        }

        // 마지막 VIP 이후 남은 구간 처리
        result *= f[N - last];

        System.out.println(result);
    }
}

