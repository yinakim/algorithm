package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한_문자_만들기 {
    public static String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true; // 다음 문자 대문자여야 할지 구분하는 상태값

        // 1. 모든문자열 검사
        for (char c : s.toCharArray()) {
            // 1-1. 공백이면 그대로 append + 상태값 true
            if(Character.isSpaceChar(c)) {
                builder.append(c);
                toUpper = true;
                continue;
            }
            // 1-2. 공백아니면
            char alphabet = notSpaceChar(c,toUpper);
            builder.append(alphabet);
            // 2. 방금 append한 문자의 대소구분에 따라 toUpper상태값 변경
            toUpper = Character.isUpperCase(alphabet) ? false : true;
        }

        return builder.toString();
    }

    private static char notSpaceChar(char c, boolean toUpper){
        // 1-2-1. 공백아니고 상태값 true 일 때 : 대문자로 변환
        if(toUpper) return Character.toUpperCase(c);
        // 1-2-2. 공백아니고 상태값 false일 때 : 소문자로 변환
        return Character.toLowerCase(c);
    }


    public static void main(String[] args) {
        /**
         * 입출력 예
         * s	                return
         * "try hello world"	"TrY HeLlO WoRlD"
         */
        System.out.println(solution("try hello world"));
    }
}
