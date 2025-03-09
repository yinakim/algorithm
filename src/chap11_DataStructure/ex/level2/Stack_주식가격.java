package chap11_DataStructure.ex.level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584
// 고득점kit, Stack
public class Stack_주식가격 {
    /*

      prices : 초단위로 기록된 주식가격

      1 <= prices의 각 요소 <= 1만
      2 <= prices.length <= 10만

      TODO. 가격이 떨어지지 않은 기간은 몇 초인지

      ---------

      prices : [1, 2, 3, 2, 3]

      1초시점 주식가격 1원 : 안떨어짐 ) 끝까지 가격이 유지됨 --> 배열길이-1 초만큼 유지됨 : 5-1=4
      2초시점 주식가격 2원 : 안떨어짐 ) 끝까지 가격이 유지됨 --> 배열길이-2 초만큼 유지됨 : 5-2=3
      3초시점 주식가격 3원 - 1초 뒤에 가격이 떨어짐 ) 1초간 가격이 떨어지지 않음 --> 1
      4초시점 주식가격 2원 - 1초 뒤에 가격이 올라감 ) 1초간 가격이 유지됨 --> 1
      5초시점 주식가격 3원 : 안떨어짐 )  끝인데 뭘봐야되지 --> 0

      결과 : [4, 3, 1, 1, 0]

      * prices[i] = i초 시점의 주식가격
      * prices[i]가 떨어지지 않는 기간을 배열로 반환
      * 이전보다 낮은 가격이 나오면 stack에서 값을 꺼내서 하락시간 계산

      */
    private static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        // 각 가격을 stack에 저장, 가격이 떨어지는 순간을 탐색 -> 나보다 작은 값이 나오는 순간
        Stack<Integer> stack = new Stack<>(); // stack에는 가격이 떨어질 때 까지 유지되는 index 저장

        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않고, 현재 가격이 스택의 top보다 낮으면 하락발생
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop(); // 제거
                answer[idx] = i-idx;
            }
            stack.push(i); // 현재 인덱스 저장
        }

        // 스택에 남아있는 인덱스는 끝까지 가격이 유지됨 (맨 마지막)
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] =  n-1-idx;
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] prices1 = {1, 2, 3, 2, 3};
        System.out.println(java.util.Arrays.toString(solution(prices1))); // [4, 3, 1, 1, 0]

        // 테스트 케이스 2: 오름차순
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("오름차순 : "+ java.util.Arrays.toString(solution(prices2))); // [4, 3, 2, 1, 0]

        // 테스트 케이스 3: 내림차순 (즉시 하락)
        int[] prices3 = {5, 4, 3, 2, 1};
        System.out.println("내림차순 (즉시 하락) : "+ java.util.Arrays.toString(solution(prices3))); // [1, 1, 1, 1, 0]

        // 테스트 케이스 4: 등락 반복
        int[] prices4 = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.println("등락 반복 : "+ java.util.Arrays.toString(solution(prices4))); // [1, 6, 2, 4, 3, 1, 1, 1, 0]

        // 테스트 케이스 5: 동일한 가격 유지
        int[] prices5 = {2, 2, 2, 2, 2};
        System.out.println("가격유지 : "+ java.util.Arrays.toString(solution(prices5))); // [4, 3, 2, 1, 0]
    }
}
