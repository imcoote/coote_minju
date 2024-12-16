/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(100×R×Clogmax(R,C))
 * 메모리: 21600 kb
 * 시간: 276 ms
 *******************************************************************************/
import java.util.*;

public class Two_dimensional {
    static int[][] R_calc(int[][] lst) {
        int rowNum = lst.length;
        List<List<Integer>> outLst = new ArrayList<>();

        int maxLen = 0;
        for (int i = 0; i < rowNum; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int num : lst[i]) {
                if (num == 0) continue;  // 0은 무시
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            List<int[]> tmpList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                tmpList.add(new int[]{entry.getKey(), entry.getValue()});
            }

            tmpList.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

            List<Integer> newRow = new ArrayList<>();
            for (int[] pair : tmpList) {
                newRow.add(pair[0]);
                newRow.add(pair[1]);
            }

            while (newRow.size() > 100) {
                newRow.remove(newRow.size() - 1);
            }

            outLst.add(newRow);
            maxLen = Math.max(maxLen, newRow.size());
        }

        int[][] result = new int[rowNum][maxLen];
        for (int i = 0; i < rowNum; i++) {
            List<Integer> row = outLst.get(i);
            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }
        return result;
    }

    static int[][] C_calc(int[][] lst) {
        int rowLen = lst.length;
        int colLen = lst[0].length;
        List<List<Integer>> outLst = new ArrayList<>();
        for (int i = 0; i < colLen; i++) outLst.add(new ArrayList<>());

        int maxLen = 0;
        for (int c = 0; c < colLen; c++) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int r = 0; r < rowLen; r++) {
                if (lst[r][c] == 0) continue;  // 0은 무시
                countMap.put(lst[r][c], countMap.getOrDefault(lst[r][c], 0) + 1);
            }

            List<int[]> tmpList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                tmpList.add(new int[]{entry.getKey(), entry.getValue()});
            }

            tmpList.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

            for (int[] pair : tmpList) {
                outLst.get(c).add(pair[0]);
                outLst.get(c).add(pair[1]);
            }

            while (outLst.get(c).size() > 100) {
                outLst.get(c).remove(outLst.get(c).size() - 1);
            }

            maxLen = Math.max(maxLen, outLst.get(c).size());
        }

        int[][] result = new int[maxLen][colLen];
        for (int c = 0; c < colLen; c++) {
            List<Integer> col = outLst.get(c);
            for (int r = 0; r < col.size(); r++) {
                result[r][c] = col.get(r);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() - 1;  // 1-based → 0-based
        int c = sc.nextInt() - 1;
        int k = sc.nextInt();

        int[][] initLst = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                initLst[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        int[][] curLst = initLst;

        while (cnt <= 100) {
            if (r < curLst.length && c < curLst[0].length && curLst[r][c] == k) {
                System.out.println(cnt);
                return;
            }

            // R 연산 또는 C 연산
            if (curLst.length >= curLst[0].length) {
                curLst = R_calc(curLst);  // R
            } else {
                curLst = C_calc(curLst);  // C
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
