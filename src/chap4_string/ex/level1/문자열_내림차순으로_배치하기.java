package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class 문자열_내림차순으로_배치하기 {
    public static String solution(String s) {

        return s.chars()    // IntStream 으로 변환
                .boxed()    // Stream<Integer> 로 변환
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, // 정수말고 문자형식으로
                        StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * s	        return
         * "Zbcdefg"	"gfedcbZ"
         */
        System.out.println(solution("Zbcdefg"));
    }
}
