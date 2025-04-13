/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n)
 * 메모리: 23748 kb
 * 시간: 200 ms
 *******************************************************************************/
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class zero {
    public static void main(String[] args) throws IOException{
        // scanner 시간초과 떠서 BufferedReader로 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); // 숫자 몇개 입력 받을건지

        // 엣지 케이스 처리, 처음부터 0일시 그냥 0 출력
        if (a == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> lst = new ArrayList<Integer>(); // 장부 만들기

        for (int i = 0; i < a; i ++) {
            int num = Integer.parseInt(br.readLine());
            // 만약 num이 0이면 ArrayList 맨 뒤 숫자 제거
            if (num == 0) {
                if (!lst.isEmpty()) {
                    lst.remove(lst.size() - 1);
                }
            } else{ // 0이 아니면 해당 숫자를 장부에 추가
                lst.add(num);
            }
        }
        int sum = 0;
        for (int j : lst) // 장부에 있는 모든 숫자 합산
            sum += j;
        System.out.println(sum); // 합산 값 출력
    }
}