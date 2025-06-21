/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(2^치킨집수 × 집수 × M)
 * 메모리: 19744 kb
 * 시간: 196 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 치킨배달 {
    static int N, M;
    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 크기
        M = Integer.parseInt(st.nextToken()); // 최대 치킨집 개수

        map = new int[N][N];

        // 도시 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // 치킨집 중 M개 고르기 (조합)
        comb(0, 0, new ArrayList<>());

        // 결과 출력
        System.out.println(result);
    }

    // 백트래킹으로 치킨집 M개 고르기
    static void comb(int start, int depth, List<int[]> selected) {
        if (depth == M) {
            int totalDistance = getCityChickenDistance(selected);
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            comb(i + 1, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    // 선택된 치킨집들로 도시 치킨 거리 계산
    static int getCityChickenDistance(List<int[]> selected) {
        int sum = 0;
        for (int[] house : houses) {
            int min = Integer.MAX_VALUE;
            for (int[] chicken : selected) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                min = Math.min(min, dist);
            }
            sum += min;
        }
        return sum;
    }
}

