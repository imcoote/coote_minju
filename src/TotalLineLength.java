/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도:O(NlogN)
 * 메모리: 331172 kb
 * 시간: 1652 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class TotalLineLength {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 읽기
        int n = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            lines.add(new int[]{x, y});
        }

        // 시작점 기준 정렬 (시작점이 같다면 끝점 기준)
        lines.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // 병합 및 총 길이 계산
        int mergedStart = lines.get(0)[0];
        int mergedEnd = lines.get(0)[1];
        long totalLength = 0;

        for (int i = 1; i < n; i++) {
            int start = lines.get(i)[0];
            int end = lines.get(i)[1];

            if (start <= mergedEnd) { // 겹치는 구간 병합
                mergedEnd = Math.max(mergedEnd, end);
            } else { // 현재 구간 끝남
                totalLength += mergedEnd - mergedStart;
                mergedStart = start;
                mergedEnd = end;
            }
        }

        // 마지막 병합된 구간 추가
        totalLength += mergedEnd - mergedStart;

        // 결과 출력
        System.out.println(totalLength);
    }
}
