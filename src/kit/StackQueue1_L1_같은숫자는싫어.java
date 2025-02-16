package kit;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class StackQueue1_L1_같은숫자는싫어 {

    public static void main(String[] args) {
        /**
         * 입출력 예
         * arr	            answer
         * [1,1,3,3,0,1,1]	[1,3,0,1]
         * [4,4,4,3,3]	    [4,3]
         */

        int[] arr = new int[]{1,1,3,3,0,1,1};
        int[] arr2 = new int[]{4,4,4,3,3};
        System.out.println(Arrays.toString(solution(arr)));
        System.out.println(Arrays.toString(solution(arr2)));
    }


    /**
     * 제한사항
     * 배열 arr의 크기 : 1,000,000 이하의 자연수
     * 배열 arr의 원소의 크기 : 0 ~ 9 정수
     */
    private static int[] solution(int []arr) {
        // 큐 생성(순서 유지), 단 중복없이
        Queue<Integer> que = new LinkedList<>();

        que.offer(arr[0]); // 0번째 나오는 수는 반복 되던 안되던 일단 하나 들어가긴 해야됨
        for(int i=0; i < arr.length-1 ; i++){
            if(arr[i] != arr[i+1]) que.offer(arr[i+1]); // 중복은 있어도 되는데  순서를 지켜야함,  앞에 온 데이터가 중복되면 안넣어야됨
        }

        // 큐에서 꺼내서 배열만들기
        int[] result = new int[que.size()];

        for(int i=0; i < result.length; i++){ // que.size() 만큼 하면 poll 할 때마다 que.size바뀌니까 안됨
            int x = que.poll();
            result[i] = x;
        }

        return result;
    }
}
