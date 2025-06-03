/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 25624 kb
 * 시간: 240 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ContinuousSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int sum = 0;
        int max_num = arr[0];

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > max_num) {
                max_num = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(max_num);
    }
}


