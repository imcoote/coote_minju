/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(NlogN)
 * 메모리: 21060 kb
 * 시간: 236 ms
 *******************************************************************************/
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        Arrays.sort(times);

        int currentSum = 0;
        int finalSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += times[i];
            finalSum += currentSum;
        }

        System.out.println(finalSum);
        sc.close();
    }
}
