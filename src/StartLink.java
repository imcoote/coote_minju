/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도:O(N)
 * 메모리: 54556 kb
 * 시간: 628 ms
 *******************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartLink {
    static int N;
    static int[][] S;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        N = sc.nextInt();
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // 조합을 저장할 리스트
        List<Integer> team = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            team.add(i);
        }

        // 조합 생성 및 처리
        combine(new ArrayList<>(), 0);

        // 결과 출력
        System.out.println(minDiff);
    }

    // 조합 생성 함수
    static void combine(List<Integer> startTeam, int index) {
        if (startTeam.size() == N / 2) {
            // 링크 팀 계산
            List<Integer> linkTeam = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!startTeam.contains(i)) {
                    linkTeam.add(i);
                }
            }

            // 능력치 계산
            int startScore = calculateScore(startTeam);
            int linkScore = calculateScore(linkTeam);

            // 최소 차이 갱신
            minDiff = Math.min(minDiff, Math.abs(startScore - linkScore));
            return;
        }

        for (int i = index; i < N; i++) {
            startTeam.add(i);
            combine(startTeam, i + 1);
            startTeam.remove(startTeam.size() - 1);
        }
    }

    // 능력치 계산 함수
    static int calculateScore(List<Integer> team) {
        int score = 0;
        for (int i : team) {
            for (int j : team) {
                score += S[i][j];
            }
        }
        return score;
    }
}
