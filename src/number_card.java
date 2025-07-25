/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(1)
 * 메모리: 136136 kb
 * 시간: 836	ms
 *******************************************************************************/
// HashSet(중복 없이 빠르게 값을 저장하고 찾고 싶을 때)
// contains() 매서드 사용
import java.io.*;
import java.util.*;

public class number_card {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());// 숫자 카드(N)
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 상근이가 가진 카드들을 Set에 저장
        Set<Integer> cards = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken())); // ex)6 3 2 10 -10
        }

        int M = Integer.parseInt(br.readLine()); // 확인할 숫자들(M)
        st = new StringTokenizer(br.readLine());

        // 각 숫자에 대해 상근이가 가지고 있는지 확인(contains())
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(cards.contains(num) ? "1 " : "0 "); //StringBuilderdp 1 or 0을 붙임
        }

        System.out.println(sb.toString().trim());
    }
}

