package chap4_string.ex.level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class 자연수_뒤집어_배열로_만들기 {

    public static int[] solution(long n) {


        // 입력받은 숫자를 문자열로 변환
        String str = Long.toString(n);

        // 문자열 뒤집기 reverse
        String reversed = new StringBuilder(str).reverse().toString();

        // 뒤집힌 문자열을 배열로 변환 toCharArray
        char[] arr = reversed.toCharArray();

        // 배열 각 요소를 정수로 변환
        int[] answer = new int[arr.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = arr[i] - '0'; // 모든 문자열에서 - '0'하면 정수로 변환됨
        }

        return answer;
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * n	    return
         * 12345	[5,4,3,2,1]
         */
        System.out.println(Arrays.toString(solution(12345l)));
    }
}
