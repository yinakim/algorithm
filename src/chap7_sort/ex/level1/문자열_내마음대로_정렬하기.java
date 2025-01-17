package chap7_sort.ex.level1;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class 문자열_내마음대로_정렬하기 {

    public static String[] solution(String[] strings, int n) {

        // 주어진 문자열들을 n번째 문자를 이용하여 정렬하는 문제
        // 문자열 비교 :  뺄셈 이용
        // n번째 문자 가져오기 : charAt()

        //Arrays.sort(strings, Comparator.comparingInt(s -> s.charAt(n))); // 원소를 int값으로 나타낸 후 정렬해야 하는 경우 사용

        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)) return s1.charAt(n) - s2.charAt(n);
            return s1.compareTo(s2);
        });
        return strings;
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * strings	                n	return
         * ["sun", "bed", "car"]	1	["car", "bed", "sun"]
         * ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
         */

        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));

    }

}
