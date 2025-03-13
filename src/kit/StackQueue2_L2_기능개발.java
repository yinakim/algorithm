package kit;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class StackQueue2_L2_기능개발 {

    public static void main(String[] args) {
        /**
         * 입출력 예
         * progresses	                speeds	            return
         * [93, 30, 55]	                [1, 30, 5]	        [2, 1]
         * [95, 90, 99, 99, 80, 99]	    [1, 1, 1, 1, 1, 1]	[1, 3, 2]
         */

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

        int[] progresses2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
    }

    /**
     * 앞선 작업이 완료되지 않으면 뒤의 작업을 완료할 수 없으므로 progresses, speeds를 차례로 확인 --> 각 작업을 큐에 넣고 하나씩 검사
     * 하나의 작업을 검사할 때, 해당 작업이 종료되는 시점 계산 가능
     * - 종료 시점 <= 현재까지 흐른시간 ? 이전작업과 함께 완료됨
     * - 종료 시점 > 현재까지 흐른 시간 ? 이전작업 완료 이후 추가작업 해야 함
     *
     * @param progresses 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 배열
     * @param speeds 작업의 개발속도가 적힌 정수배열
     * @return 각 배포마다 배포되는 기능의 수
     */
    private static int[] solution(int[] progresses, int[] speeds) {
        // 각 작업 인덱스를 넣고 하나씩 검사
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            que.add(i); // progresses, speeds를 순서대로 참조하기 위함
        }

        int days = 0;   // 현재 시간
        int count = 0;  // 얼마나 많은 작업이 동시에 완료되는지 카운팅
        List<Integer> result = new ArrayList<>(); // 동시에 완료되는 작업의 개수

        // 큐에 검사할 작업이 있으면, 해당 작업의 인덱스를 받아와서 검사를 수행
        while (!que.isEmpty()) {
            int index = que.poll();
            /**
             * index 번째 작업 검사
                - 작업의 진행도 : progresses[index] (즉, 100-progresses[index] 만큼 지나야 완료)
                - 작업의 속도 : speeds[index]
                - 예상 완료시간 : expiration
             */
            int expiration = (int) Math.ceil((double) (100-progresses[index]) / speeds[index]);

            // 예상 완료시간 vs 현재시간 비교
            // 1. 현재 검사하는 작업이 이전 작업들과 같이 종료되는지 :
            // 2. 추가 작업이 필요한지 : 기존에 세고있던 동시에 완료되는 작업개수 result에 넣고 진행된 시간 업데이트
            if(expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++; // 현재 작업 count
        }

        // 마지막에 검사한 작업들 count 기록 후 배열로 변환
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}