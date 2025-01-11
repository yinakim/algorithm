package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class 시저암호 {
    public static String solution(String s, int n) {
        // 입력문자열의 모든 문자열을 반복
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            builder.append(push(c,n)); // 반환된 문자 이어붙이기(append)
        }
        return builder.toString();
    }

    /*
      알파벳이 아닌 경우(isAlphabetic) 그대로 반환
      알파벳인 경우 n만큼 밀어진 문자 반환
      공백도 그대로 반환
    */
    private static char push (char c, int n) {
        // 알파벳이 아닌 경우(isAlphabetic),
        if(!Character.isAlphabetic(c)) return c;

        //c를 n만큼 밀어서 반환 : 알파벳을 0~25로 변환해서 밀기
        int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 대문자범위면 A부터 시작, 소문자범위면 a부터시작
        int position = c - offset; // offset 기준으로 대소문자 범위 내의 c의 위치값
        position = (position + n) % ('Z'-'A'+1); // 가능한 position 범위는 0~('Z'-'A')

        // offset에서 n만큼 밀린(position)문자로 반환
        return (char) (offset + position);
    }

    // ------------------ test ------------------ //
    public static void main(String[] args) {
        /**
         * 입출력 예
         * s	    n	result
         * "AB"	    1	"BC"
         * "z"	    1	"a"
         * "a B z"	4	"e F d"
         */
        System.out.println(solution("AB",1));
        System.out.println(solution("z",1));
        System.out.println(solution("a B z",4));

    }
}
