package kit;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public interface Graph1_L3_가장먼노드 {

    public static void main(String[] args) {
        /**
         * 입출력 예
         * n	vertex	                                                    return
         * 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
         */
        int n = 6;
        int[][] edge = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        System.out.println(solution(n,edge));
        System.out.println(solution2(n,edge));
    }


    /**
     * 가장 멀리 떨어진 노드 개수 구하기 ---> 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드
     *
     *
     *
     */
    private static int solution(int n, int[][] edge) {
        // 가장 멀리 떨어진 노드 개수 구하기 ---> 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드

        // ✅ 1. 그래프를 인접리스트로 변환 List<List<Integer>>, 노드 개수가 list 사이즈
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i <= n; i++){         // 노드 1~n 사용 (0번은 사용 X) - 그래프 문제에서 1번 노드부터 시작하면, n+1 크기로 배열을 만드는 게 일반적인 패턴
            graph.add(new ArrayList<>());
        }

        // ✅ 2. 그래프 생성 (양방향 무방향 같은거) - 노드 번호 별로 연결될 수 있는 노드번호 배열 graph세팅
        for(int[] e: edge) {
            System.out.println("e ::::: " + Arrays.toString(e));
            System.out.println("e[0] = " + e[0]);
            System.out.println("e[1] = " + e[1]);
            System.out.println("graph.get(e[0]) = "+graph.get(e[0]));
            System.out.println("graph.get(e[1]) = "+graph.get(e[1]));
            System.out.println("**********************************");

            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);

            System.out.println("e[1]값이 들어간 graph.get(e[0]) = "+graph.get(e[0]));
            System.out.println("e[0]값이 들어간 graph.get(e[1]) = "+graph.get(e[1]));
            System.out.println(graph);
        }
        System.out.println("1. 그래프만들고, edge저장했음 / 노드는 index 1~n+1까지고, 배열은 0~n이라서 여기서 생성된 graph[0]는 빈 배열이다 - 노드번호와 인덱스를 1:1로 매칭하기 위해 편의상 이렇게 함 :  ");
        System.out.println(graph);
        System.out.println();

//        System.out.println("---------------------- 노드 번호 별 연결 확인 ----------------------");
//        for (int i = 0; i < graph.size(); i++) {
//            System.out.println(i +"번 노드 ) 와 연결된 노드번호 들 : " + graph.get(i));
//        }

        // ✅ 3. 각 노드까지의 최단거리를 저장할 배열 (방문여부 확인용도)
        int[] distance = new int[n+1]; // 노드는 1번부터 n번까지 존재,  배열 인덱스는 0부터 시작 ---> 노드 번호와 배열 인덱스를 동일하게 맞추려면 n+1로 생성하는 게 편리
        Arrays.fill(distance, -1); // distance 배열 미방문상태 (-1)로 초기화
        /*
            distance[i] == -1 → 아직 방문하지 않은 노드
            distance[i] >= 0 → 방문한 노드 (거리가 기록됨)
            만약 0으로 초기화하면 "시작 노드와의 거리"와 방문 여부를 헷갈릴 수 있음.

            시작점은 0, 방문한 노드는 거리 업데이트, -1은 미방문
        */

        // ✅ 4. BFS 탐색용 Queue선언
        Queue<Integer> queue = new LinkedList<>();

        // ✅ 5. 시작노드(1) 큐에 넣고 거리는 0으로 설정
        queue.offer(1);
        distance[1] = 0;

        /////////////////////
        // ✅ 6. BFS 최단거리 탐색 수행 : 모든 노드까지의 최단 거리를 구하고, 그중에서 최댓값을 가지는 노드 개수를 세면 됨.
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.println("curr(polled value): "+curr);

            // ✅ 현재 노드와 연결된 모든 노드 탐색
            for(int next : graph.get(curr)){
                System.out.println("graph.get(curr) : "+graph.get(curr));
                System.out.println("next 요소 : "+next);

                System.out.println("distance[next] : "+distance[next]);
                // 미방문 노드만 처리
                if(distance[next] == -1) {
                    distance[next] = distance[curr] + 1; // 현재 거리+1
                    queue.offer(next);
                    System.out.println("방문 처리 후 queue : "+queue);
                }
            }
        }

        // ✅ 7. 가장 먼 거리 찾기
        int maxDistance = 0; // 최대값 저장변수
        int count = 0; // 최대거리 인 노드개수

        // distance 배열을 순회하면서, 큰 거리값 count
        for (int d : distance) {
            if (d > maxDistance) {
                maxDistance = d; // 더 큰 거리값이 나오면 갱신하고,
                count = 1;       // 최대거리인 노드 개수 1개로 초기화, 더 큰값이 나왔으니까

            } else if (d == maxDistance) {
                count++;         // 최대거리인 노드가 추가됨
            }
        }
        return count;
    }

    /**
     * 가장 멀리 떨어진 노드 개수 구하기 ---> 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드
     * TODO 아래 힌트 이용해서 다시 풀어보기
     *  1. 그래프를 인접리스트로 변환 List<List<Integer>>, 노드 개수가 list 사이즈
     *  2. 그래프 생성 (양방향 무방향 같은거) - 노드 번호 별로 연결될 수 있는 노드번호 배열 graph세팅
     *  3. 각 노드까지의 최단거리를 저장할 배열 (방문여부 확인용도)
     *  4. BFS 탐색용 Queue선언
     *  5. 시작노드(1) 큐에 넣고 거리는 0으로 설정
     *  6. BFS 최단거리 탐색 수행 : 모든 노드까지의 최단 거리를 구하고, 그중에서 최댓값을 가지는 노드 개수를 세면 됨.
     *  7. 가장 먼 거리 찾기
     */
    private static int solution2(int n, int[][] edge) {
        //  1. 그래프를 인접리스트로 변환 List<List<Integer>>, 노드 개수가 list 사이즈
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 노드 n+1개에 대한 graph 생성해야 됨
        }

        //  2. 그래프 생성 (양방향 무방향 같은거) - 노드 번호 별로 연결될 수 있는 노드번호 배열 graph세팅
        for (int[] eg : edge) { // int[][]에서 한줄씩 꺼내면 int[]

            // [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]] -> 이렇게 요소 2개씩 서로 양방향 연결되어있으니까
            graph.get(eg[0]).add(eg[1]);
            graph.get(eg[1]).add(eg[0]);
        }

        //  3. 각 노드까지의 최단거리를 저장할 배열, 방문여부 확인값 세팅 (방문여부 확인용도)
        int[] distance = new int[n+1]; // 위 [1] 번에서도 n+1개 생성했음
        Arrays.fill(distance, -1); // 방문여부 확인값 -1로 일단 전부 미방문상태로 초기화

        //  4. BFS 탐색용 Queue선언
        Queue<Integer> que = new LinkedList<>();

        //  5. 시작노드(1) 큐에 넣고 거리는 0으로 설정
        que.offer(1);
        distance[1] = 0;

        //  6. BFS 최단거리 탐색 수행 : 모든 노드까지의 최단 거리를 구하고, 그중에서 최댓값을 가지는 노드 개수를 세면 됨.
        while (!que.isEmpty()) {
            int curNodeNo = que.poll();
            // graph 배열 순회하면서, curNodeNo(현재 노드)의 인접 노드를 방문
            for (int next : graph.get(curNodeNo)) {
                if(distance[curNodeNo] == -1) { // 미방문 상태인 경우
                    distance[next] = distance[curNodeNo] + 1;   // 방문처리 해주고
                    que.offer(next);                            // 방문처리 된 node를 queue에 넣기
                }
            }
        }

        //  7. 가장 먼 거리 찾기 :  최댓값을 가지는 노드 개수 구하기
        int maxDistance = 0; // 최장거리값 변수
        int count = 0; // return값, 최장거리값에 해당되는 노드개수

        // 거리 배열 순회하면서 최대값, 그 최대값을 가진 노드count 찾기
        for (int d : distance) {
            if(d > maxDistance) {           // 최대값이 갱신되는 경우 count 다시 1개
                maxDistance = d;
                count = 1;
            } else if (d == maxDistance) {  // 최대값이 일치하는 경우 count 증가
                count++;
            }
        }

        return count;
    }
}
