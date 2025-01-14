package chap4_string.ex.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class 두개_뽑아서_더하기 {
    public static int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        // 인접한 인덱스에 있는 2 개의 수를 뽑아서 합을 구하고 Set에 넣기
        for(int i=0; i < numbers.length; i++){
            for(int j=i+1; j < numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue) // Stream<Integer> 를 IntStream로 변환
                .sorted()                   // 정렬
                .toArray();                 // 최종리턴타입 int[] 만들기
    }

    // ----------- test -------------- //
    public static void main(String[] args) {
        /**
         * 입출력 예
         * numbers	    result
         * [2,1,3,4,1]	[2,3,4,5,6,7]
         * [5,0,2,7]	[2,5,7,9,12]
         */
        int[] numbers = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};

        System.out.println(Arrays.toString(solution(numbers)));
        System.out.println(Arrays.toString(solution(numbers2)));

    }
}
