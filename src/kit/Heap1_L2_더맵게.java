package kit;

import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class Heap1_L2_더맵게 {
    /**
     * Heap(힙)은 우선순위 큐(PriorityQueue) 를 구현하는 데 사용됨
     * 코딩 테스트에서 최소값/최대값을 빠르게 찾을 때 자주 활용
     * PriorityQueue 사용, 최소 힙 / 최대 힙 구현가능 (기본은 최소힙, 최대힙을 찾으려면 Collections.reverseOrder() 이용)
     */
    public static void main(String[] args) {

        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;
        System.out.println(solution(scoville1, K1)); // 2

        int[] scoville2 = {0, 0, 3, 9, 10, 12};
        int K2 = 7;
        System.out.println(solution(scoville2, K2)); // 3

        int[] scoville3 = {1, 1, 1, 1};
        int K3 = 10;
        System.out.println(solution(scoville3, K3)); // -1
    }

    private static int solution(int[] scoville, int K) {
        // K의 범위 0 ~ 10억, scoville 각각 0 ~ 1백만
        // K이상이 안되면 -1 리턴

        // 1. 최소 힙 생성 - 우선순위큐, 기본적으로 최소힙으로 동작
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int s : scoville) {
            heap.offer(s);
        }

        // 2. mixing 과정 - 가장 작은 두개의 스코빌값을 꺼냄, 새로운 스코빌 계산 결과를 다시 힙에 삽입
        // mixing 과정이 끝나면 mixing 횟수 ++
        int mixCnt = 0;
        while(heap.size() > 1 && heap.peek() < K){
            int first = heap.poll(); // 가장 작은 스코빌
            int second = heap.poll(); // 두번째 작은 스코빌

            int newScoville = first + (second*2);
            heap.offer(newScoville);
            mixCnt++;
        }

        // 가장 작은 scoville 지수가 K이상이면 종료
        // 큐에서 다 꺼내 써서 큐의 크기가 1 이하인데도 K이상 scoville을 만들 수 없다면? return -1
        return heap.peek() >= K ? mixCnt : -1;
    }
}
