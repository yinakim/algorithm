package doit.basic.search;

import java.util.*;

/**
 * DFS와 BFS
 */
// 문제 https://www.acmicpc.net/problem/1260
// 강의 https://www.youtube.com/watch?v=3qjxqbC5CYk&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=27
public class Bj_1260_DFS_BFS {
    // 방문처리배열
    static boolean visited[];
    static ArrayList<Integer>A[];

    public static void main(String[] args) {
        /**
         * 입력1
           4 5 1
           1 2
           1 3
           1 4
           2 4
           3 4

           출력
           1 2 4 3
           1 2 3 4

           입력2
           5 5 3
           5 4
           5 2
           1 2
           3 4
           3 1

           출력2
           3 1 2 5 4
           3 1 4 2 5
         */

        // 노드, 엣지, 시작점 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        // 배열초기화
        A = new ArrayList[N+1];

        // 배열 하나하나 ArrayList
        for (int i=1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // 그래프 데이터 세팅
        for (int i = 0; i < M ; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();

            // 양방향
            A[S].add(E);
            A[E].add(S);
        }

        // 오름차순 정렬
        for (int i = 1; i < N; i++) {
            Collections.sort(A[i]);
        }

        System.out.println();

        // 방문배열 초기화, DFS
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        // 방문배열 초기화, BFS
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        // 큐에 시작노드 넣고, 방문처리
        queue.add(node);
        visited[node] = true;

        // 큐가 존재하지 않을 때 까지 BFS 진행
        while (!queue.isEmpty()) {
            // 시작노드 뽑고 출력
            int newNode = queue.poll();
            System.out.print(newNode+" ");

            // 아직 방문하지 않은 노드는 방문처리 후 큐에 추가
            for (int i: A[newNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }

    private static void DFS(int node) {
        // 출력 후 방문처리
        System.out.print(node+" ");
        visited[node] = true;

        // 재귀함수로 DFS
        for (int i: A[node]) {
            // 방문하지 않은 노드만 탐색진행
            if(!visited[i]) DFS(i);
        }
    }
}
