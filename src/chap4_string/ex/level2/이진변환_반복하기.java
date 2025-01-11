package chap4_string.ex.level2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class 이진변환_반복하기 {
    /* 받은 문자열 s를 한글자씩확인, '0'의 개수 반환 */
    private static int zeroCnt(String s){
        int zeros = 0;
        for (char c : s.toCharArray()){
            if('0' == c) zeros++;
        }
        return zeros;
    }

    public static int[] solution(String s) {
        int loop = 0;       // 반복횟수 loop
        int removedZero = 0;// 제거한 0의 개수

        // 1이 될 때 까지 변환반복
        while (!"1".equals(s)){
            // [1] 문자열에 포함된 0의 개수 removedZero에 저장, loop 증가
            int zeros = zeroCnt(s);
            loop += 1;
            removedZero += zeros;

            // [2] 나머지 1의 개수로 만들어진 s의 길이값을 2진법으로 변환
            int ones = s.length()-zeros;      // 1만남은 길이값
            s = Integer.toString(ones, 2);  // 2진수로 변환해서 다시 s에 대입
        }

        // loop번 반복하는 동안 removedZero개의 0을 제거했으므로
        return new int[] {loop, removedZero};
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * s	            result
         * "110010101001"	[3,8]
         * "01110"	        [3,3]
         * "1111111"	    [4,1]
         */
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }
}
