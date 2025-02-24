package chap8_이진탐색.ex.level3;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// 힌트 : https://school.programmers.co.kr/learn/courses/14743/lessons/118892
public class 입국심사 {

    public static void main(String[] args) {
        /**
         * 입출력 예
         * n	times	return
         * 6	[7, 10]	28
         */
        int n1 = 6;
        int[] times1 = {7, 10};
        System.out.println(solution(n1, times1)); // 28

        int n2 = 10;
        int[] times2 = {3, 8, 15};
        System.out.println(solution(n2, times2)); // 21

        int n3 = 5;
        int[] times3 = {2, 2, 2, 2, 2};
        System.out.println(solution(n3, times3)); // 2
    }

    /**
     최소 시간을 찾는 최적화 문제 --> 이분탐색 활용
        - 가능한 시간을 범위로 설정하고 탐색하는 방식이 효과적
        - 시간 안에 n명 이상을 심사할 수 있는지 여부를 기준으로 이진탐색 진행

     1. 최소 시간, 최대 시간 설정
     - [최소시간: left] min(times) : 가장 빠른 심사관이 한명을 심사하는 경우, 1분이상
     - [최대시간: right] max(times) * n : 가장 느린 심사관이 모든 사람을 심사하는 경우, n명 심사 다 하는경우
     [최소시간] ~ [중앙값] ~ [최대시간]

     2. 이분탐색 진행
     - 중앙값 계산, mid = (최소시간 + 최대시간)/2
     - mid 시간 동안 심사할 수 있는사람의 수 확인 --> mid값 갱신
     - end 갱신 : 심사할 수 있는 사람이 n보다 많거나 같으면 시간이 충분하므로 right를 줄여서 더 짧은 시간도 가능한지 확인
     - start 갱신 : 반대로 n보다 적다면 시간이 부족하므로 left를 증가

     */
    public static long solution(int n, int[] times) {
        // 이분탐색 진행하기 위해 일단 정렬
        Arrays.sort(times);

        // 1. 최소값, 최대값 지정
        long left = 1; // 최소시간(1분, 문제조건에 1~10억 이하)
        long right = (long) times[times.length - 1] * n; // 최대시간(최악의 경우 가장 느린 심사관이 모든 사람을 다 심사하는 경우)
        long answer = right; // 일단 최대로 지정하고 시작

        // 최소한 같아지는 시간까지 탐색, 최소-최대 시간이 역전될 때 까지 반복
        while (left <= right) {

            // 2. 중앙값 구하기, 갱신하기 ->  탐색 범위를 반으로 줄이면서 최적의 값을 찾아야 하기 때문에, 탐색과정에서  중앙값을 갱신해서 탐색범위를 줄여야 함
            long mid = (left+right)/2;

            long totalPeople = 0;
            for (int time : times) {
                totalPeople += mid / time;  // 각 심사관이 mid 시간동안 심사할 수 있는 인원
                if(totalPeople >= n) break; // 이미 n명을 초과하면 계산할 필요 없음, for반복 종료
            }

            if(totalPeople >= n) {
                answer = mid;     // 더 적은 시간이 가능한지 탐색
                right = mid - 1;  // [end값-1 까지]로 탐색범위 좁히기 위함
            } else {
                left = mid +1; // 시간이 부족하므로 늘려야함 .. 즉 [start+1 부터]로 탐색범위 좁히기 위함
            }
        }
        return answer;
    }
}
