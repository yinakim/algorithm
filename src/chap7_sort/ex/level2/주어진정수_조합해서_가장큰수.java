package chap7_sort.ex.level2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// 정렬(Sorting) 을 활용하여 가장 큰 수를 만드는 문제
public class 주어진정수_조합해서_가장큰수 {
    /**
     0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

     예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
     TODO 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
     하도록 solution 함수를 작성해주세요.

     제한 사항
     - numbers의 길이는 1 이상 100,000 이하입니다.
     - numbers의 원소는 0 이상 1,000 이하입니다.

     정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

     TODO 정렬(Sorting) 을 활용하여 가장 큰 수를 만드는 문제, 일반적인 숫자 정렬(오름차순 또는 내림차순)로 해결되지 않으며, 커스텀 정렬 기준을 만들어야
     */

    public static void main(String[] args) {
        /**
         * 입출력 예
         * numbers	            return
         * [6, 10, 2]	        "6210"
         * [3, 30, 34, 5, 9]	"9534330"
         */

        int[] arr1 = new int[]{6, 10, 2};
        int[] arr2 = new int[]{3, 30, 34, 5, 9};
        int[] arr3 = new int[]{0, 0, 0};
        System.out.println(getBigger(arr1)); // 6210 - [6, 2, 10]
        System.out.println(getBigger(arr2)); // 9534330 - [9, 5, 34, 3, 30]
        System.out.println(getBigger(arr3)); // 9534330 - [0, 0, 0]
    }

    private static String getBigger(int[] numbers){
        // 1. 숫자를 문자열로 변환
        String[] strNums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 2. a+b > b+a 비교, 커스텀 정렬 : 큰 수가 앞에 오도록 정렬하여 전부 이어붙이면 가장 큰 수가 나올테니까
        Arrays.sort(strNums, (a,b) -> (b+a).compareTo(a+b));
        System.out.println("정렬된 strNums : " + Arrays.toString(strNums));

        // 3. (예외처리) 모든 숫자가 0이면 0리턴 : 가장 큰 수를 맨앞으로 정렬했는데 맨앞이 0이라면 배열 모든요소가 0이므로 "000"이 아닌 0을 반환
        if(strNums[0].equals("0")) return "0";

        // 4. 정렬된 숫자 이어붙이기
        return String.join("",strNums);
    }


    /*
    [compareTo]
    - 자바에서 문자열 or 숫자(Comparble객체*)를 비교할 때 사용하는 메서드
    - this 객체와 o 객체를 비교하여 양수, 0, 음수 반환 (오름차순 정렬 기준)
    */


}
