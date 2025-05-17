/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(K)
 * 메모리: 14312 kb
 * 시간: 104 ms
 *******************************************************************************/
/**
 * 1. 톱니바퀴 4개 초기 상태 입력받기
 * 2. 회전 횟수 K 입력
 * 3. 현재 톱니의 회전 방향 설정, 왼쪽/오른쪽 톱니를 차례로 확인하여 연쇄 회전 여부 및 방향 결정
 * 4. 실제 회전 수행
 * 5. 마지막으로 점수 계산
 * **/

import java.io.*;
import java.util.*;

public class gear {
    static Deque<Character>[] gears = new Deque[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 톱니바퀴 4개 상태 입력받기
        for (int i = 0; i < 4; i++) {
            gears[i] = new ArrayDeque<>();
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                gears[i].add(c);
            }
        }

        // 2. 회전 횟수 K 입력
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int dir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계

            // 3-1. 각 톱니의 회전 방향을 저장할 배열
            int[] rotateDir = new int[4];
            rotateDir[gearNum] = dir;

            // 3-2. 왼쪽 톱니들 확인 (연쇄 회전 여부 결정)
            for (int i = gearNum - 1; i >= 0; i--) {
                char right6 = getIndex(gears[i + 1], 6);
                char left2 = getIndex(gears[i], 2);
                if (right6 != left2) {
                    rotateDir[i] = -rotateDir[i + 1]; // 방향 반대로
                } else {
                    break;
                }
            }

            // 3-3. 오른쪽 톱니들 확인
            for (int i = gearNum + 1; i < 4; i++) {
                char left2 = getIndex(gears[i - 1], 2);
                char right6 = getIndex(gears[i], 6);
                if (left2 != right6) {
                    rotateDir[i] = -rotateDir[i - 1]; // 방향 반대로
                } else {
                    break;
                }
            }

            // 4. 실제 회전 수행
            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] == 1) {
                    rotateClockwise(gears[i]);
                } else if (rotateDir[i] == -1) {
                    rotateCounterClockwise(gears[i]);
                }
            }
        }

        // 5. 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].peekFirst() == '1') {
                score += (1 << i); // 2^i
            }
        }

        System.out.println(score);
    }

    // 시계 방향 회전(마지막을 맨 앞으로)
    static void rotateClockwise(Deque<Character> gear) {
        char last = gear.pollLast();
        gear.addFirst(last);
    }

    // 반시계 방향 회전(맨 앞을 맨 뒤로)
    static void rotateCounterClockwise(Deque<Character> gear) {
        char first = gear.pollFirst();
        gear.addLast(first);
    }

    // 톱니의 특정 index 가져오기 (Deque를 배열처럼 접근)
    static char getIndex(Deque<Character> gear, int index) {
        Iterator<Character> it = gear.iterator();
        for (int i = 0; i < index; i++) it.next();
        return it.next();
    }
}

