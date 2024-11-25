/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(n * m)
 * 메모리: 17736 kb
 * 시간: 172 ms
 *******************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Coin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> coinList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int b = scanner.nextInt();
            coinList.add(b);
        }

        Collections.reverse(coinList);

        int cnt = 0;
        for (int coin : coinList) {
            if (k == 0) break;
            cnt += k / coin;
            k %= coin;
        }

        System.out.println(cnt);
        scanner.close();
    }
}
