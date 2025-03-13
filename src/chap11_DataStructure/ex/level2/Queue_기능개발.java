package chap11_DataStructure.ex.level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 기능개발 다르게 풀어보기
public class Queue_기능개발 {
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

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // 각 기능의 완료까지 필요한 일 수 계산 후 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        while (!queue.isEmpty()) {
            int count = 1;
            int first = queue.poll();

            // 앞 기능이 배포될 때 함께 배포될 기능 찾기
            while (!queue.isEmpty() && queue.peek() <= first) {
                count++;
                queue.poll();
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
