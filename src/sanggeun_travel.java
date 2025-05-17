/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(m)
 * 메모리: 243488 kb
 * 시간: 964 ms
 *******************************************************************************/
import java.util.Scanner;

public class sanggeun_travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수

        while (t-- > 0) {
            int n = sc.nextInt(); // 국가 수
            int m = sc.nextInt(); // 비행기 수

            // 사용자가 입력을 하긴 하니까 그걸 처리해주는 코드
            // 사용자 입력값 필요없음 굳이 저장할 필요 x
            // 모든 국가 방문을 무조건 해야하면 모든 국가가 이어져 있다는 뜻이므로 답은 무조건 n-1
            for (int i = 0; i < m; i++) {
                sc.nextInt(); sc.nextInt();
            }

            System.out.println(n - 1);
        }
    }
}


