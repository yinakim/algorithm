package chap6_완전탐색.ex.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class 없는숫자더하기 {
    public static void main(String[] args) {
        /**
         * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
         * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
         *
         * 1 ≤ numbers의 길이 ≤ 9
         * 0 ≤ numbers의 모든 원소 ≤ 9
         * numbers의 모든 원소는 서로 다릅니다.
         *
         * 입출력 예
         * numbers	result
         * [1,2,3,4,6,7,8,0]	14
         * [5,8,4,0,6,7,9]	6
         */

        int[] arr = new int[]{1,2,3,4,6,7,8,0};
        int[] arr2 = new int[]{5,8,4,0,6,7,9};
        System.out.println(solution(arr));
        System.out.println(solution(arr2));

        System.out.println(solution2(arr));
        System.out.println(solution2(arr2));
    }

    // Stream 이용한 풀이
    private static int solution2(int[] numbers) {
        return IntStream.rangeClosed(0, 9)
                .filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num))
                .sum();
    }

    private static int solution(int[] numbers) {
        int sum = 0;

        // 0 ~ 9까지 모두 더한 sum에서 numbers에 들어간 값을 빼면 남은 sum이 없는 수의 값
        // 등차수열 합공식 이용(n=가장큰수), S = n(n+1)/2
        sum = (9*(9+1))/2;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }


}
