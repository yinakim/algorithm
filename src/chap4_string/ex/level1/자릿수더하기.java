package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class 자릿수더하기 {
    public static int solutionByStr(int n) {
        int sum = 0;
        String s = Integer.toString(n);
        for(int i=0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }


    /**
     1. n을 10으로 나눈 나머지를 통해 마지막 자릿수 구하기
     2. n을 10으로 나눈 나머지 자리수 제거
     3. n=0이 될때까지 반복
     */
    public static int solutionByRemain(int n) {
        int sum = 0;
        while( n > 0 ){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        /**
         * 입출력 예
         * N	answer
         * 123	6
         * 987	24
         */

        System.out.println("문자열활용) " + solutionByStr(123));
        System.out.println("문자열활용) " + solutionByStr(987));

        System.out.println("나머지연산 활용) " + solutionByRemain(123));
        System.out.println("나머지연산 활용) " + solutionByRemain(987));

    }
}
