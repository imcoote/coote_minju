/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도:O(N⋅(N−1)!)
 * 메모리: 502412 kb
 * 시간: 1144 ms
 *******************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxMinCalc {
    static int n; // 숫자의 개수
    static int[] numbers; // 숫자 배열
    static List<List<Integer>> permutations = new ArrayList<>(); // 연산자 순열 저장
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // 연산자 정보 받기
        int[] operators = new int[4]; // 0: +, 1: -, 2: *, 3: /
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 연산자 리스트 생성
        List<Integer> operatorList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operators[i]; j++) {
                operatorList.add(i);
            }
        }

        // 연산자 순열 생성
        genePermutation(new ArrayList<>(), operatorList, new boolean[operatorList.size()]);

        // 순열별 계산 및 최대/최소값 갱신
        for (List<Integer> permutation : permutations) {
            int result = calculate(permutation);
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
        }

        // 결과 출력
        System.out.println(maxValue);
        System.out.println(minValue);

        sc.close();
    }

    // 순열 생성 함수
    static void genePermutation(List<Integer> current, List<Integer> operators, boolean[] used) {
        if (current.size() == operators.size()) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(operators.get(i));
                genePermutation(current, operators, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    // 계산 함수
    static int calculate(List<Integer> operators) {
        int result = numbers[0];

        for (int i = 0; i < operators.size(); i++) {
            int operator = operators.get(i);
            int nextNumber = numbers[i + 1];

            if (operator == 0) { // 덧셈
                result += nextNumber;
            } else if (operator == 1) { // 뺄셈
                result -= nextNumber;
            } else if (operator == 2) { // 곱셈
                result *= nextNumber;
            } else if (operator == 3) { // 나눗셈
                if (result < 0) {
                    result = -(-result / nextNumber);
                } else {
                    result /= nextNumber;
                }
            }
        }

        return result;
    }
}

