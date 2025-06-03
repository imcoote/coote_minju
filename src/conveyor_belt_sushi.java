/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 18768 kb
 * 시간: 164 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class conveyor_belt_sushi {
    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 접시 수, d: 초밥 가짓수, k: 연속해서 먹는 접시 수, c: 쿠폰 초밥 번호
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 초밥 벨트 입력
        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; // 각 초밥 종류별 개수 카운트 배열 (1번부터 d번까지)
        int unique = 0; // 현재 슬라이딩 윈도우 내 초밥 종류 개수

        // 초기 윈도우 설정: 첫 k개의 초밥 종류 수 세기
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) unique++; // 처음 먹는 종류면 종류 수 증가
            count[belt[i]]++;
        }

        // 쿠폰 초밥을 따로 고려하여 초기 최대값 설정
        int max = unique;
        if (count[c] == 0) max++; // 쿠폰 초밥이 포함 안 되어 있다면 +1

        // 슬라이딩 윈도우: 한 칸씩 오른쪽으로 밀면서 계산 (원형이므로 %N 사용)
        for (int i = 1; i < N; i++) {
            // 제거되는 초밥
            int remove = belt[(i - 1) % N];
            // 추가되는 초밥
            int add = belt[(i + k - 1) % N];

            // 초밥 제거 처리
            count[remove]--;
            if (count[remove] == 0) unique--; // 종류가 0개가 되면 종류 수 감소

            // 초밥 추가 처리
            if (count[add] == 0) unique++; // 처음 보는 종류면 증가
            count[add]++;

            // 쿠폰 초밥이 현재 윈도우에 없으면 +1
            int total = unique;
            if (count[c] == 0) total++;

            // 최대값 갱신
            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}


