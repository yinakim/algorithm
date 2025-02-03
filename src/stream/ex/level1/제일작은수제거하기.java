package stream.ex.level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class 제일작은수제거하기 {
    /**
     * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴
     * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴
     */
    public static int[] removeMin(int[] arr) {
        if(arr.length == 1) {
            arr[0] = -1; // 최소값 제거 결과 빈배열인 경우 -1 리턴 (요소가 1개라면 최소값 제거 후 빈배열)
            return arr;
        }

        // array to List
        //List<int[]> list = Arrays.asList(arr);

        int min = Arrays.stream(arr).min().getAsInt();
        // int max = Arrays.stream(arr).max().getAsInt(); // 참고, 최대값 구하기

        // remove min
        //list.remove(min);

        // List to array
        // 배열을 스트림으로 변환한 후 최소값 제거
        return Arrays.stream(arr)
                .filter(i -> i != min) // 최소값 제외
                .toArray();
    }

    public static void main(String[] args) {

        /**
         입출력           예
         arr	        return
         [4,3,2,1]	    [4,3,2]
         [10]	        [-1]
         */

        int[] ex1 = {4, 3, 2, 1};
        int[] ex2 = {10};
        System.out.println(Arrays.toString(removeMin(ex1)));
        System.out.println(Arrays.toString(removeMin(ex2)));
    }

}
