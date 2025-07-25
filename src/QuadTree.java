/*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(n²)
 * 메모리: 14764 kb
 * 시간: 112	 ms
 *******************************************************************************/
// (왼쪽 위)(오른쪽 위)(왼쪽 아래)(오른쪽 아래)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuadTree {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 입력받은 영상 데이터를 2차원 배열에 저장
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자를 정수로 변환
            }
        }

        // (0, 0) 좌표부터 크기 n × n의 전체 영상을 압축
        System.out.println(compress(0, 0, n)); // 압축 결과 출력
    }

    // (x, y)부터 size 크기 영역을 쿼드 트리 방식으로 압축
    public static String compress(int x, int y, int size) {

        // 해당 영역의 값이 전부 같으면 더 나눌 필요 없이 "0" 또는 "1"을 반환
        if (isAllSame(x, y, size)) {
            return String.valueOf(map[x][y]); // 해당 숫자 반환
        }

        int half = size / 2; // 영역 4등분
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(compress(x, y, half));               // 왼쪽 위
        sb.append(compress(x, y + half, half));        // 오른쪽 위
        sb.append(compress(x + half, y, half));        // 왼쪽 아래
        sb.append(compress(x + half, y + half, half)); // 오른쪽 아래
        sb.append(")");

        return sb.toString();
    }

    // 해당 영역이 모두 같은 숫자인지 확인
    public static boolean isAllSame(int x, int y, int size) {
        int value = map[x][y];
        // 이중 for문으로 size x size 영역 전체를 검사
        // 하나라도 다르면 false, 전부 같으면 true
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != value) return false;
            }
        }
        return true;
    }
}


