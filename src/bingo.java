/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(1)
 * 메모리: 14132 kb
 * 시간: 104 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bingo {
    static List<Set<Integer>> bingoLines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];

        // 철수의 빙고판 입력 받기
        for (int i = 0; i < 5; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 빙고 라인 12개 구성
        initBingoLines(board);

        // 사회자가 부른 숫자 처리
        int callCount = 0;
        for (int i = 0; i < 5; i++) {
            String[] callRow = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(callRow[j]);
                callCount++;

                // 모든 빙고 라인에서 숫자 제거
                for (Set<Integer> line : bingoLines) {
                    line.remove(call);
                }

                // 빙고 라인 중 완성된 줄 수 세기
                int bingoCount = 0;
                for (Set<Integer> line : bingoLines) {
                    if (line.isEmpty()) bingoCount++;
                }

                if (bingoCount >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }
    }

    // 12개의 빙고 줄 생성: 가로 5, 세로 5, 대각선 2
    static void initBingoLines(int[][] board) {
        // 가로줄
        for (int i = 0; i < 5; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                row.add(board[i][j]);
            }
            bingoLines.add(row);
        }

        // 세로줄
        for (int j = 0; j < 5; j++) {
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                col.add(board[i][j]);
            }
            bingoLines.add(col);
        }

        // 대각선
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            diag1.add(board[i][i]);
            diag2.add(board[i][4 - i]);
        }
        bingoLines.add(diag1);
        bingoLines.add(diag2);
    }
}



