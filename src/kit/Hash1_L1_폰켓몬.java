package kit;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// 폰켓몬
public class Hash1_L1_폰켓몬 {
    public static void main(String[] args) {
        /**
         * 입출력 예
         * nums	            result
         * [3,1,2,3]	    2
         * [3,3,3,2,2,4]	3
         * [3,3,3,2,2,2]	2
         */

        int[] arr1 = new int[]{3,1,2,3};
        int[] arr2 = new int[]{3,3,3,2,2,4};
        System.out.println(getNums(arr1));
        System.out.println(getNums(arr2));

    }

    private static int getNums(int[] nums) {
        /**
         * 최대한 다양한 종류의 폰켓몬을 포함해서 N/2마리를 선택
         *
         *  N마리 폰켓몬의 종류 번호가 담긴 배열 nums ===> 중복없이 봤을 때 key 배열로 쓸수있음, Set? 이용?
         *  N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법
         *
         *
         *  (제한)
         *  1. nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수 (1만)
         *  2. 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다. (20만)
         *  3. 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
         */
        int answer = 0;

        // N값 구하기
        int N = nums.length;

        // Set 생성, 종류번호넣기
        Set set = new HashSet<>();
        for(int i=0; i < N; i++){
            set.add(nums[i]);
        }

        int cnt = set.size();
        int half = N/2;
        if( cnt <= half) {
            answer = cnt;
        } else if (cnt > half) {
            answer = half;
        }
        return answer;
    }


}
