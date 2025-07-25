/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 14128 kb
 * 시간: 104	 ms
 *******************************************************************************/
// 그리디
// n개의 노드와 m개의 리프
// 간선이 n-1개이며 리프 노드는 정확히 m개
// 끝에서부터 리프를 만들자
import java.io.*;
import java.util.*;

public class 트리만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄에 입력된 n m 값을 공백 기준으로 나누기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 리프 수

        StringBuilder sb = new StringBuilder();

        // 1. 루트 노드(0)에 m개의 리프 노드 연결
        for (int i = 1; i <= m; i++) {
            sb.append("0 ").append(i).append("\n");
        }

        // 2. 나머지 노드들을 체인처럼 연결
        int prev = 1; // 첫 내부 노드
        for (int i = m + 1; i < n; i++) {
            sb.append(prev).append(" ").append(i).append("\n");
            prev = i;
        }

        // 출력
        System.out.print(sb);
    }
}

