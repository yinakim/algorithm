package chap7_sort.ex.level1;

import java.util.Arrays;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12933#
public class 정수_내림차순으로_배치하기 {

    public static Long solution(long n){
        // long > str 변환
        String str = Long.toString(n);

        // 문자열 > 배열
        String[] arr = str.split("");

        // 배열 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        // 내림차순 결과 > 문자열
        String s = String.join("",arr);

        // str > long 변환
        return Long.parseLong(s);
    }

    public static void main(String[] args) {
        /**
         * 입출력     예
         * n	    return
         * 118372	873211
         * 118375	875311
         */
        System.out.println(solution(118372l));
        System.out.println(solution(118375l));
    }
}
