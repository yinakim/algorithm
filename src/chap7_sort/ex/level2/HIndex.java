package chap7_sort.ex.level2;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class HIndex {
    private static boolean isValid(int[] arr, int h){
        return arr[arr.length-h] >= h;
    }

    public static int solution(int[] citations) {
        // [1] citations 요소 중 h조건 만족하는지 검사 (요소 각각 전수조사)
        // h의 범위 : 0~입력받은 논문개수 (배열 길이) - 1편 이상 1,000편 이하니까 요소전체를 마지막 1편 남을 때 까지 검사

        Arrays.sort(citations);
        for(int h = citations.length; h >= 1; h-- ){
            // [2] h 조건 만족하는 최대값(H-Index) 나오면 바로 리턴
            if(isValid(citations, h)) return h;
        }
        return 0; // 인용회수 0회 이상 10,000회 이하
    }

    // ------------------ test ------------------ //
    public static void main(String[] args) {
        /**
         * 입력
         * citations [3, 0, 6, 1, 5]
         * 출력
         * 3
         */
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
