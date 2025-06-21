/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(N log N)
 * 메모리: 68244 kb
 * 시간: 616 ms
 *******************************************************************************/
import java.io.*;
import java.util.*;

public class 강의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 시작 시간 기준 정렬
        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        // 우선순위 큐: 현재 열려 있는 강의실의 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]); // 첫 수업 종료 시간 삽입

        for (int i = 1; i < N; i++) {
            int start = lectures[i][0];
            int end = lectures[i][1];

            // 가장 빨리 끝나는 강의실이 비어있다면 → 그 강의실 재사용
            if (pq.peek() <= start) {
                pq.poll(); // 비운다
            }

            // 현재 수업 종료시간 추가
            pq.add(end);
        }

        // 남아있는 강의실 수 = 최소 필요 강의실 수
        System.out.println(pq.size());
    }
}

