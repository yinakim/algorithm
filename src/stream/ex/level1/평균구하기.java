package stream.ex.level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12944
public class 평균구하기 {
    private static double getAvg(int[] arr) {
        // 총합
        //int sum = Arrays.stream(arr).sum();

        // 평균
        return Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * arr	        return
         * [1,2,3,4]	2.5
         * [5,5]	    5
         */

        int[] arr = new int[]{1,2,3,4};
        int[] arr2 = new int[]{5,5};
        System.out.println(Double.toString(getAvg(arr))); // 2.5
        System.out.println(Double.toString(getAvg(arr2))); // 5.0
    }
}
