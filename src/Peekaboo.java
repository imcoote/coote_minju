/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(N)
 * 메모리: 25852 kb
 * 시간: 224 ms
 *******************************************************************************/
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Peekaboo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        System.out.println(findFastestTime(N, K));
    }

    public static int findFastestTime(int N, int K) {
        if (N >= K) {
            return N - K;
        }

        int maxPosition = 100000;
        int[] visited = new int[maxPosition + 1];
        for (int i = 0; i <= maxPosition; i++) {
            visited[i] = -1;
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();


            if (current == K) {
                return visited[current];
            }


            int[] nextPositions = {current - 1, current + 1, current * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= maxPosition && visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}