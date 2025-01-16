package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class 숫자_문자열과_영단어 {
    public static int solution(String s) {
        String[] words = { "zero","one","two","three","four","five","six","seven","eight","nine" };

        // 배열 순회하며 s에서 등장하는 모든 영단어 치환된 s생성
        for (int i=0; i<words.length; i++){
            s = s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

    // ========= test ========= //
    public static void main(String[] args) {
        /**
         * 입출력 예
         * s	                result
         * "one4seveneight"	    1478
         * "23four5six7"	    234567
         * "2three45sixseven"	234567
         * "123"	            123
         */

        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

}
