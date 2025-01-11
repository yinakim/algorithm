package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        String str = s.toLowerCase();
        int pCnt = s.length() - str.replace("p","").length();
        int yCnt = s.length() - str.replace("y","").length();
        return pCnt == yCnt;
    }
}
