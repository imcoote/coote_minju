/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도:O(N)
 * 메모리: 188572 kb
 * 시간: 984 ms
 *******************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(scanner.nextLine().trim()));
        }

        Collections.sort(ropes);

        int maxWeight = ropeWeight(ropes);
        System.out.println(maxWeight);

        scanner.close();
    }

    public static int ropeWeight(ArrayList<Integer> ropes) {
        int maxWeight = 0;
        int size = ropes.size();

        for (int i = 0; i < size; i++) {
            maxWeight = Math.max(maxWeight, ropes.get(i) * (size - i));
        }

        return maxWeight;
    }
}

