/*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(N × M)
 * 메모리: 305996 kb
 * 시간: 10164 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hacking {
    static int N, M;
    static ArrayList <Integer>[] arr;
    static boolean isVisited[];
    static int max;
    static int cntArr[];

    static void DFS(int start) {
        isVisited[start] = true;
        for (int i : arr[start]) {
            if (isVisited[i]) continue;
            cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
            DFS(i);
        }
    }

    static void BFS(int start) {
        Queue <Integer> que = new ArrayDeque<Integer>();

        que.add(start);
        isVisited[start] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            for (int i : arr[now]) {
                if (isVisited[i]) continue;
                cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
                isVisited[i] = true;
                que.add(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        cntArr = new int[N+1];

        // 신뢰 관계 입력
        arr = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) arr[i] = new ArrayList <Integer>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b); // a가 b를 신뢰, a는 b에게 해킹 당할 수 있음
        }

        // 1번부터 N번까지 search
        for (int i=1; i<N+1; i++) {
            isVisited = new boolean[N+1];
            //DFS(i); // 메모리↓ 시간↑
            BFS(i); // 메모리↑ 시간↓

        }

        // 해킹할 수 있는 최댓값 찾기
        for (int i=1; i<N+1; i++) {
            if (max<cntArr[i]) max = cntArr[i];
        }

        // 최댓값인 컴퓨터 출력
        for (int i=1; i<N+1; i++) if (max == cntArr[i]) System.out.print(i+" ");
    }

}

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static List<List<Integer>> graph = new ArrayList<>();
//    static boolean[] visited;
//    static int[] count;
//    static int max_cnt = 0;
//    static List<Integer> result = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        // 시간 초과 떠서 StringTokenizer 사용
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        // 정점 셋팅
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        // 간선 m개 입력
//        // A가 B를 신뢰 → B → A 방향
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine()); //!!
//            int c = Integer.parseInt(st.nextToken());
//            int d = Integer.parseInt(st.nextToken());
//            graph.get(d).add(c);
//        }
//
//        //정점(컴퓨터)을 해킹했을 때 감염시킬 수 있는 컴퓨터 수
//        count = new int[n + 1];
//
//        // 모든 정점에서 dfs 실행
//        for (int i = 1; i <= n; i++) {
//            visited = new boolean[n + 1];
//            count[i] = dfs(i);
//            max_cnt = Math.max(max_cnt, count[i]);
//        }
//
//        // 최대값을 가진 정점들 저장
//        for (int i = 1; i <= n; i++) {
//            if (count[i] == max_cnt) {
//                sb.append(i).append(" ");
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
//    static int dfs(int node) {
//        visited[node] = true;
//        int cnt = 1;
//
//        for (int next : graph.get(node)) {
//            if (!visited[next]) {
//                cnt += dfs(next);
//            }
//        }
//
//        return cnt; // 계산 결과 저장
//    }
//}
