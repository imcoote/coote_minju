/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(n * m)
 * 메모리: 174244 kb
 * 시간: 1104 ms
 *******************************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Meetingroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = scanner.nextInt(); // 시작 시간
            meetings[i][1] = scanner.nextInt(); // 종료 시간
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0;
        int endTime = 0;

        // 회의 선택
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= endTime) {
                count++;
                endTime = meetings[i][1];
            }
        }

        System.out.println(count);
        scanner.close();
    }
}

